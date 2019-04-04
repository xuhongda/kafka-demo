package com.xu.pojo;



import lombok.*;

import java.sql.Timestamp;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DeviceStatushis implements java.io.Serializable {

	protected String recUid;
	
	protected Timestamp sampleTime = new Timestamp(System.currentTimeMillis());
	
	protected String deviceId;
	
	protected String objId;
	
	// protected Timestamp recordTime;
	// protected Short serviceStatus;
	protected Short onlineStatus;
	
	protected Short alarmStatus;
	
	protected Timestamp alarmTime;
	
	// protected Short posMethod;
	protected Timestamp posTime;
	
	// protected Short posPrecision;
	protected Double posLongitude;
	
	protected Double posLatitude;
	
	protected Integer posAltitude;
	
	protected Integer posSpeed;
	
	// protected Integer posDirection;
	// protected String networkDataId;
	protected Double accForward;
	
	protected Double accSide;
	
	protected Double accVerticle;
	
	// protected Short rolloverLevel;
	// protected Short voltageLevel;
	// protected Short collisionLevel;
	// protected Short signalLevel;
	protected Double powerVoltage;
	
	// protected String gid;
	// protected String gateNo;
	protected Short accStatus;
	

	protected String softwareVersion;
	
	protected Integer duration;
	

	
}
