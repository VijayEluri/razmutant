/**  ____    __    ____  ____  ____,,___     ____  __  __  ____
 *  (  _ \  /__\  (_   )(_  _)( ___)/ __)   (  _ \(  )(  )(  _ \           Read
 *   )   / /(__)\  / /_  _)(_  )__) \__ \    )___/ )(__)(  ) _ <     README.txt
 *  (_)\_)(__)(__)(____)(____)(____)(___/   (__)  (______)(____/    LICENSE.txt
 */
package com.razie.dist.db;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;

import razie.assets.AssetBase;
import razie.assets.AssetBrief;
import razie.assets.AssetBriefImpl;
import razie.assets.AssetKey;
import razie.assets.AssetLocation;

import com.razie.pub.UnknownRtException;
import com.razie.pub.agent.Agent;
import com.razie.pub.agent.AgentFileService;
import razie.base.ActionItem;
import razie.base.AttrAccess;
import razie.base.AttrAccessImpl;
import razie.draw.DrawStream;

import com.razie.pub.base.log.Log;
import com.razie.pub.comms.AgentHandle;
import com.razie.pub.comms.Agents;
import com.razie.pub.comms.Comms;
import com.razie.pub.lightsoa.SoaAsset;
import com.razie.pub.lightsoa.SoaMethod;
import com.razie.pub.lightsoa.SoaStreamable;

/**
 * each agent maintains a database - this is distributed and synchronized between agents
 * 
 * <p>
 * this maintains several databases. some are sync'd automatically, some are not...the databases are
 * maintained in the mutant default folder
 * 
 * <p>
 * a database is managed like an XML file - structure is important. you can address elements by
 * xpath and etc
 * 
 * @author razvanc
 * @version $Id$
 * 
 */
@SoaAsset(meta = "AgentDb.razie", descr = "simple xml distributed agent database")
public class AgentDb implements AssetBase {
    public static String           EVT_NEWDB    = "newdb.AgentDb";
    public static String           EVT_UPDATEDB = "updatedb.AgentDb";
    public static String           EVT_REMOVEDB = "removedb.AgentDb";

    public static String           sCLASS       = "AgentDb.razie";
    public static final ActionItem META         = new ActionItem(sCLASS, "/public/pics/documents.png");

    static Map<String, AgentDb>    dbs          = new HashMap<String, AgentDb>();

    XmlDb                          myDb         = null;
    String                         dbname;
    AssetKey                       key;

    /** get dbs using AgentDb.db(name) instead */
    protected AgentDb(String dbname, XmlDb db) {
        this.dbname = dbname;
        this.myDb = db;
        key = new AssetKey(sCLASS, dbname, AssetLocation.mutantEnv(Agents.getMyHostName(), ""));
    }

    public XmlDb xml() {
        return myDb;
    }

    public static AgentDb db(String dbname) {
        return dbImpl(dbname);
    }

    public static AgentDb reload(String dbname) {
        dbs.remove(dbname);
        return db(dbname);
    }

    /** TODO 2-1 factory here */
    protected static AgentDb dbImpl(String dbname) {
        if (!dbs.containsKey(dbname)) {
            XmlDb xdb = new XmlDb();
            URL url = xdb.getClass().getResource(dbname + ".xml");

            if (url == null) {
                // one more try - in development i don't have the same classpath...
                File f = new File(filenamefor(dbname));
                if (f.exists()) {
                    try {
                        url = f.toURI().toURL();
                    } catch (MalformedURLException e) {
                        throw new UnknownRtException(e);
                    }
                }
            }

            if (url == null) {
                xdb.initialize(dbname);
                dbs.put(dbname, new AgentDb(dbname, xdb));
            } else {
                xdb.load(dbname, url);
                dbs.put(dbname, new AgentDb(dbname, xdb));
            }
        }

        return dbs.get(dbname);
    }

    private static String filenamefor(String dbname) {
        // need different dir for test host...
        return AgentFileService.getInstance().basePath() + "/" + (Agents.instance().testing ? "TESTHOSTDB/xdb_" : "xdb_") + dbname + ".xml";
    }

    public void save(boolean forcesave, boolean notify) {
        if (xml().prepareForSave() || forcesave) {
            this.xml().xmlize(filenamefor(dbname));
            if (notify)
                Agent.instance().notifyOthers(EVT_UPDATEDB, razie.JAA.of("dbname", dbname));
        }
    }

    /** delete the file and db */
    public void delete(boolean notify) {
        db(dbname).close();
        dbs.remove(dbname);
        File f = new File(filenamefor(dbname));
        f.delete();
        if (notify)
            Agent.instance().notifyOthers(EVT_REMOVEDB, razie.JAA.of("dbname", dbname));
    }

    /** the two DB names must normally match - use 2 for testing */
    public static void sync(String dbname, AgentHandle fromHost, String remotedbname, boolean notifyOthers) {
//        MutantProvider mutant = new MutantProvider(fromHost);
        Log.logThis("SYNC_DB name=" + dbname + " fromHost=" + fromHost);
//        if (mutant.isUp()) {
        if (AgentHandle.DeviceStatus.UP.equals(fromHost.status)) {
            // TODO 2-1 change to ATI
            // TODO 2-1 change from public to dedicated xdb service to serve these files
            String url = "http://" + fromHost.ip + ":"
                    + fromHost.port + "/mutant/local/xdb_" + remotedbname + ".xml";
            XmlDb remotedb = new XmlDb();

//            String otherList = (Comms.readUrl(url));

            try {
                remotedb.load(dbname, new URL(url));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

            if (dbs.containsKey(dbname)) {
                AgentDb db = db(dbname);
                synchronized (db) {
                    db.xml().syncfrom(remotedb);
                    db.save(true, notifyOthers);
                }
            } else {
                // it's brand new...
                Element settings = remotedb.xpe("/db/settings");
                settings.setAttribute("lastsyncver", String.valueOf(remotedb.xpa("/db/settings/@ver")));

                dbs.put(dbname, new AgentDb(dbname, remotedb));
                db(dbname).save(true, notifyOthers);
            }
            Log.logThis("SYNCD_DB name=" + dbname + " fromHost=" + fromHost);
        } else {
            Log.logThis(fromHost + " is not up - can't sync db: " + dbname);
        }
    }

    /** list local databases
     * 
     * @return map of <dbname,version>
     */
    public static AttrAccess listLocalDb() {
        AttrAccess map = new AttrAccessImpl();
        File[] files = new File (AgentFileService.getInstance().basePath()).listFiles(
              new java.io.FilenameFilter() {
           public boolean accept(File dir, String name) {
              return name.matches("xdb_.*\\.xml");
           }
        });
           
        for (File f : files) {
            String dbname = f.getName().replaceAll("\\.xml", "");
            dbname = dbname.replaceAll("^xdb_", "");
            XmlDb x = new XmlDb();
            try {
                x.load(dbname, f.toURI().toURL());
                String ver = x.xpa("/db/settings/@ver");
                map.setAttr(dbname, ver);
            } catch (MalformedURLException e) {
                Log.logThis("couldn't open local xdb: " + dbname, e);
            }
        }
        return map;
    }

    /** close and dump from mem */
    public void close() {
        save(false, true);
    }

    @SoaMethod(descr = "returns the actual xml for this db")
    @SoaStreamable(mime="application/xml")
    public void display(DrawStream out) {
        out.write (xml().xmlize(null));
    }

    @Override
    public AssetBrief getBrief() {
      return brief(); 
    }
    
    @Override
    public AssetBrief brief() {
        AssetBriefImpl b = new AssetBriefImpl();
        b.setKey(getKey());

        // b.setIcon(stream.getAttribute("icon"));
        b.setBriefDesc("a database...");

        b.setName(b.getKey().getId());

        return b;
    }

    public AssetKey key() {
        return key;
    }

    public AssetKey getKey() {
        return key;
    }

}
