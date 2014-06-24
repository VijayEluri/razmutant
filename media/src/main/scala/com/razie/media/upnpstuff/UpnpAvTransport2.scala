/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.razie.media.upnpstuff

trait UpnpAvTransport2 {

        def Stop (InstanceID : String)

        def Play (InstanceID : String, Speed:String)

        def Next (InstanceID : String)

        def Previous (InstanceID : String)

        <Optional/>
        def Pause (InstanceID : String)



//        @UpnpVar (descr="transportstate")
        val TransportState : String


	<serviceStateTable>
		<stateVariable>
			<name>TransportState</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
			<allowedValueList>
				<allowedValue>STOPPED</allowedValue>
				<allowedValue>PLAYING</allowedValue>
			</allowedValueList>
		</stateVariable>

		<stateVariable>
			<name>TransportStatus</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
			<allowedValueList>
				<allowedValue>OK</allowedValue>
				<allowedValue>ERROR_OCCURRED</allowedValue>
			</allowedValueList>
		</stateVariable>

		<stateVariable>
			<name>CurrentMediaCategory</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
			<allowedValueList>
				<allowedValue>NO_MEDIA</allowedValue>
				<allowedValue>TRACK_AWARE</allowedValue>
				<allowedValue>TRACK_UNAWARE</allowedValue>
			</allowedValueList>
		</stateVariable>

		<stateVariable>
			<name>PlaybackStorageMedium</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>RecordStorageMedium</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>PossiblePlaybackStorageMedia</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>PossibleRecordStorageMedia</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>CurrentPlayMode</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
			<allowedValueList>
				<allowedValue>NORMAL</allowedValue>
			</allowedValueList>
			<defaultValue>NORMAL</defaultValue>
		</stateVariable>

		<stateVariable>
			<name>TransportPlaySpeed</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
			<allowedValueList>
				<allowedValue>1</allowedValue>
			</allowedValueList>
			<defaultValue>1</defaultValue>
		</stateVariable>

		<stateVariable>
			<name>RecordMediumWriteStatus</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>CurrentRecordQualityMode</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>PossibleRecordQualityModes</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>NumberOfTracks</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>ui4</dataType>
			<allowedValueRange>
				<minimum>0</minimum>
			</allowedValueRange>
		</stateVariable>

		<stateVariable>
			<name>CurrentTrack</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>ui4</dataType>
			<allowedValueRange>
				<minimum>0</minimum>
				<step>1</step>
			</allowedValueRange>
		</stateVariable>

		<stateVariable>
			<name>CurrentTrackDuration</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>CurrentMediaDuration</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>CurrentTrackMetaData</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>CurrentTrackURI</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>AVTransportURI</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>AVTransportURIMetaData</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>NextAVTransportURI</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>NextAVTransportURIMetaData</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>RelativeTimePosition</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>AbsoluteTimePosition</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>RelativeCounterPosition</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>i4</dataType>
		</stateVariable>

		<stateVariable>
			<name>AbsoluteCounterPosition</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>i4</dataType>
		</stateVariable>

		<stateVariable>
			<Optional/>
			<name>CurrentTransportActions</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>LastChange</name>
			<sendEventsAttribute>yes</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<Optional/>
			<name>DRMState</name>
			<sendEventsAttribute>yes</sendEventsAttribute>
			<dataType>string</dataType>
			<allowedValueList>
				<allowedValue>OK</allowedValue>
			</allowedValueList>
			<defaultValue>UNKNOWN</defaultValue>
		</stateVariable>

		<stateVariable>
			<name>A_ARG_TYPE_SeekMode</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
			<allowedValueList>
				<allowedValue>TRACK_NR</allowedValue>
			</allowedValueList>
		</stateVariable>

		<stateVariable>
			<name>A_ARG_TYPE_SeekTarget</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<name>A_ARG_TYPE_InstanceID</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>ui4</dataType>
		</stateVariable>

		<stateVariable>
			<Optional/>
			<name>A_ARG_TYPE_DeviceUDN</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<Optional/>
			<name>A_ARG_TYPE_ServiceType</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<Optional/>
			<name>A_ARG_TYPE_ServiceID</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<Optional/>
			<name>A_ARG_TYPE_StateVariableValuePairs</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>

		<stateVariable>
			<Optional/>
			<name>A_ARG_TYPE_StateVariableList</name>
			<sendEventsAttribute>no</sendEventsAttribute>
			<dataType>string</dataType>
		</stateVariable>
	</serviceStateTable>

	<actionList>
		<action>
			<name>SetAVTransportURI</name>
			<argumentList>
				<argument>
					<name>InstanceID</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>
				</argument>
				<argument>
					<name>CurrentURI</name>
					<direction>in</direction>
					<relatedStateVariable>AVTransportURI</relatedStateVariable>
				</argument>
				<argument>
					<name>CurrentURIMetaData</name>
					<direction>in</direction>
					<relatedStateVariable>AVTransportURIMetaData</relatedStateVariable>
				</argument>
			</argumentList>
		</action>

		<action>
			<Optional/>
			<name>SetNextAVTransportURI</name>
			<argumentList>
				<argument>
					<name>InstanceID</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>
				</argument>
				<argument>
					<name>NextURI</name>
					<direction>in</direction>
					<relatedStateVariable>NextAVTransportURI</relatedStateVariable>
				</argument>
				<argument>
					<name>NextURIMetaData</name>
					<direction>in</direction>
					<relatedStateVariable>NextAVTransportURIMetaData</relatedStateVariable>
				</argument>
			</argumentList>
		</action>

		<action>
			<name>GetMediaInfo</name>
			<argumentList>
				<argument>
					<name>InstanceID</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>
				</argument>
				<argument>
					<name>NrTracks</name>
					<direction>out</direction>
					<relatedStateVariable>NumberOfTracks</relatedStateVariable>
				</argument>
				<argument>
					<name>MediaDuration</name>
					<direction>out</direction>
					<relatedStateVariable>CurrentMediaDuration</relatedStateVariable>
				</argument>
				<argument>
					<name>CurrentURI</name>
					<direction>out</direction>
					<relatedStateVariable>AVTransportURI</relatedStateVariable>
				</argument>
				<argument>
					<name>CurrentURIMetaData</name>
					<direction>out</direction>
					<relatedStateVariable>AVTransportURIMetaData</relatedStateVariable>
				</argument>
				<argument>
					<name>NextURI</name>
					<direction>out</direction>
					<relatedStateVariable>NextAVTransportURI</relatedStateVariable>
				</argument>
				<argument>
					<name>NextURIMetaData</name>
					<direction>out</direction>
					<relatedStateVariable>NextAVTransportURIMetaData</relatedStateVariable>
				</argument>
				<argument>
					<name>PlayMedium</name>
					<direction>out</direction>
					<relatedStateVariable>PlaybackStorageMedium</relatedStateVariable>
				</argument>
				<argument>
					<name>RecordMedium</name>
					<direction>out</direction>
					<relatedStateVariable>RecordStorageMedium</relatedStateVariable>
				</argument>
				<argument>
					<name>WriteStatus</name>
					<direction>out</direction>
					<relatedStateVariable>RecordMediumWriteStatus</relatedStateVariable>
				</argument>
			</argumentList>
		</action>

		<action>
			<name>GetMediaInfo_Ext</name>
			<argumentList>
				<argument>
					<name>InstanceID</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>
				</argument>
				<argument>
					<name>CurrentType</name>
					<direction>out</direction>
					<relatedStateVariable>CurrentMediaCategory</relatedStateVariable>
				</argument>
				<argument>
					<name>NrTracks</name>
					<direction>out</direction>
					<relatedStateVariable>NumberOfTracks</relatedStateVariable>
				</argument>
				<argument>
					<name>MediaDuration</name>
					<direction>out</direction>
					<relatedStateVariable>CurrentMediaDuration</relatedStateVariable>
				</argument>
				<argument>
					<name>CurrentURI</name>
					<direction>out</direction>
					<relatedStateVariable>AVTransportURI</relatedStateVariable>
				</argument>
				<argument>
					<name>CurrentURIMetaData</name>
					<direction>out</direction>
					<relatedStateVariable>AVTransportURIMetaData</relatedStateVariable>
				</argument>
				<argument>
					<name>NextURI</name>
					<direction>out</direction>
					<relatedStateVariable>NextAVTransportURI</relatedStateVariable>
				</argument>
				<argument>
					<name>NextURIMetaData</name>
					<direction>out</direction>
					<relatedStateVariable>NextAVTransportURIMetaData</relatedStateVariable>
				</argument>
				<argument>
					<name>PlayMedium</name>
					<direction>out</direction>
					<relatedStateVariable>PlaybackStorageMedium</relatedStateVariable>
				</argument>
				<argument>
					<name>RecordMedium</name>
					<direction>out</direction>
					<relatedStateVariable>RecordStorageMedium</relatedStateVariable>
				</argument>
				<argument>
					<name>WriteStatus</name>
					<direction>out</direction>
					<relatedStateVariable>RecordMediumWriteStatus</relatedStateVariable>
				</argument>
			</argumentList>
		</action>

		<action>
			<name>GetTransportInfo</name>
			<argumentList>
				<argument>
					<name>InstanceID</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>
				</argument>
				<argument>
					<name>CurrentTransportState</name>
					<direction>out</direction>
					<relatedStateVariable>TransportState</relatedStateVariable>
				</argument>
				<argument>
					<name>CurrentTransportStatus</name>
					<direction>out</direction>
					<relatedStateVariable>TransportStatus</relatedStateVariable>
				</argument>
				<argument>
					<name>CurrentSpeed</name>
					<direction>out</direction>
					<relatedStateVariable>TransportPlaySpeed</relatedStateVariable>
				</argument>
			</argumentList>
		</action>

		<action>
			<name>GetPositionInfo</name>
			<argumentList>
				<argument>
					<name>InstanceID</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>
				</argument>
				<argument>
					<name>Track</name>
					<direction>out</direction>
					<relatedStateVariable>CurrentTrack</relatedStateVariable>
				</argument>
				<argument>
					<name>TrackDuration</name>
					<direction>out</direction>
					<relatedStateVariable>CurrentTrackDuration</relatedStateVariable>
				</argument>
				<argument>
					<name>TrackMetaData</name>
					<direction>out</direction>
					<relatedStateVariable>CurrentTrackMetaData</relatedStateVariable>
				</argument>
				<argument>
					<name>TrackURI</name>
					<direction>out</direction>
					<relatedStateVariable>CurrentTrackURI</relatedStateVariable>
				</argument>
				<argument>
					<name>RelTime</name>
					<direction>out</direction>
					<relatedStateVariable>RelativeTimePosition</relatedStateVariable>
				</argument>
				<argument>
					<name>AbsTime</name>
					<direction>out</direction>
					<relatedStateVariable>AbsoluteTimePosition</relatedStateVariable>
				</argument>
				<argument>
					<name>RelCount</name>
					<direction>out</direction>
					<relatedStateVariable>RelativeCounterPosition</relatedStateVariable>
				</argument>
				<argument>
					<name>AbsCount</name>
					<direction>out</direction>
					<relatedStateVariable>AbsoluteCounterPosition</relatedStateVariable>
				</argument>
			</argumentList>
		</action>

		<action>
			<name>GetDeviceCapabilities</name>
			<argumentList>
				<argument>
					<name>InstanceID</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>
				</argument>
				<argument>
					<name>PlayMedia</name>
					<direction>out</direction>
					<relatedStateVariable>PossiblePlaybackStorageMedia</relatedStateVariable>
				</argument>
				<argument>
					<name>RecMedia</name>
					<direction>out</direction>
					<relatedStateVariable>PossibleRecordStorageMedia</relatedStateVariable>
				</argument>
				<argument>
					<name>RecQualityModes</name>
					<direction>out</direction>
					<relatedStateVariable>PossibleRecordQualityModes</relatedStateVariable>
				</argument>
			</argumentList>
		</action>

		<action>
			<name>GetTransportSettings</name>
			<argumentList>
				<argument>
					<name>InstanceID</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>
				</argument>
				<argument>
					<name>PlayMode</name>
					<direction>out</direction>
					<relatedStateVariable>CurrentPlayMode</relatedStateVariable>
				</argument>
				<argument>
					<name>RecQualityMode</name>
					<direction>out</direction>
					<relatedStateVariable>CurrentRecordQualityMode</relatedStateVariable>
				</argument>
			</argumentList>
		</action>


		<action>
			<Optional/>
			<name>Record</name>
			<argumentList>
				<argument>
					<name>InstanceID</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>
				</argument>
			</argumentList>
		</action>

		<action>
			<name>Seek</name>
			<argumentList>
				<argument>
					<name>InstanceID</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>
				</argument>
				<argument>
					<name>Unit</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_SeekMode</relatedStateVariable>
				</argument>
				<argument>
					<name>Target</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_SeekTarget</relatedStateVariable>
				</argument>
			</argumentList>
		</action>

		<action>
			<Optional/>
			<name>SetPlayMode</name>
			<argumentList>
				<argument>
					<name>InstanceID</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>
				</argument>
				<argument>
					<name>NewPlayMode</name>
					<direction>in</direction>
					<relatedStateVariable>CurrentPlayMode</relatedStateVariable>
				</argument>
			</argumentList>
		</action>

		<action>
			<Optional/>
			<name>SetRecordQualityMode</name>
			<argumentList>
				<argument>
					<name>InstanceID</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>
				</argument>
				<argument>
					<name>NewRecordQualityMode</name>
					<direction>in</direction>
					<relatedStateVariable>CurrentRecordQualityMode</relatedStateVariable>
				</argument>
			</argumentList>
		</action>

		<action>
			<Optional/>
			<name>GetCurrentTransportActions</name>
			<argumentList>
				<argument>
					<name>InstanceID</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>
				</argument>
				<argument>
					<name>Actions</name>
					<direction>out</direction>
					<relatedStateVariable>CurrentTransportActions</relatedStateVariable>
				</argument>
			</argumentList>
		</action>

		<action>
			<Optional/>
			<name>GetDRMState</name>
			<argumentList>
				<argument>
					<name>InstanceID</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>
				</argument>
				<argument>
					<name>CurrentDRMState</name>
					<direction>out</direction>
					<relatedStateVariable>DRMState</relatedStateVariable>
				</argument>
			</argumentList>
		</action>

		<action>
			<Optional/>
			<name>GetStateVariables</name>
			<argumentList>
				<argument>
					<name>InstanceID</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>
				</argument>
				<argument>
					<name>StateVariableList</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_StateVariableList</relatedStateVariable>
				</argument>
				<argument>
					<name>StateVariableValuePairs</name>
					<direction>out</direction>
					<relatedStateVariable>A_ARG_TYPE_StateVariableValuePairs</relatedStateVariable>
				</argument>
			</argumentList>
		</action>

		<action>
			<Optional/>
			<name>SetStateVariables</name>
			<argumentList>
				<argument>
					<name>InstanceID</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_InstanceID</relatedStateVariable>
				</argument>
				<argument>
					<name>AVTransportUDN</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_DeviceUDN</relatedStateVariable>
				</argument>
				<argument>
					<name>ServiceType</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_ServiceType</relatedStateVariable>
				</argument>
				<argument>
					<name>ServiceId</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_ServiceID</relatedStateVariable>
				</argument>
				<argument>
					<name>StateVariableValuePairs</name>
					<direction>in</direction>
					<relatedStateVariable>A_ARG_TYPE_StateVariableValuePairs</relatedStateVariable>
				</argument>
				<argument>
					<name>StateVariableList</name>
					<direction>out</direction>
					<relatedStateVariable>A_ARG_TYPE_StateVariableList</relatedStateVariable>
				</argument>
			</argumentList>
		</action>
	</actionList>

}