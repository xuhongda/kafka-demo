package com.xu.pojo;



import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@SuppressWarnings("serial")
@Data
@ToString
public class DeviceStatusVehicle implements java.io.Serializable {
	// Fields
	// protected String gateNo;

	protected String deviceId;
	
	// protected String appId;
	protected String objId;
	
	protected Timestamp sampleTime;
	
	protected String vin;
	// protected String fuelType;
	// protected String obdStd;
	protected Short vehicleSpeed;
	
	protected Short engineRpm;
	
	protected Double fuelPressure;
	
	protected Integer distanceTotal;
	
	protected Integer latestEngineRuntime;
	
	protected String troubleCode;
	
	protected Integer distanceAfterMil;
	
	protected Integer distanceAfterClearCode;
	
	// protected Short statusAngleSideroll;
	// protected Short statusAngleForwardroll;
	// protected Double tirePressureLeftfront;
	// protected Double tirePressureLeftrear;
	// protected Double tirePressureRightfront;
	// protected Double tirePressureRightrear;
	// protected Long carryWeight;
	// protected Short safetybeltStatus;
	protected Double storageBatteryVoltage;
	
	protected Double engineCoolliquidTemp;
	
	protected Double engineInletportTemp;
	protected Double outsideAirTemp;
	protected Double airThrottlePosition;
	// protected Double oxysensorOutputVoltage;
	protected String calcuLoad;
	
	protected Timestamp posTime;
	
	// protected Integer posPrecision;
	protected Double posLongitude;
	
	protected Double posLatitude;
	
	protected Integer posAltitude;
	
	protected Integer posSpeed;
	
	// protected Integer posDirection;
	// protected Double accForward;
	// protected Double accSide;
	// protected Double accVertical;
	// protected Integer statusAngleForward;
	// protected Integer statusAngleSide;
	// protected Integer statusAngleVertical;
	// protected String gid;
	// protected Integer statusBaseangleStatus;
	// protected Timestamp statusBaseangleTime;
	// protected Integer statusBaseangleForward;
	// protected Integer statusBaseangleSide;
	// protected Integer statusBaseangleVertical;
	protected Double gasPedalPosition;
	// protected Integer brakePedalStatus;
	// protected Double throttlePosition;
	// protected String statusLeftLight;
	// protected String statusRightLight;
	// protected String statusDoors;
	// protected String statusFuellow;
	// protected String statusAbm;
	// protected String statusTroubleLight;
	protected Double fuelConsumption;
	
	// protected String statusWindows;
	// protected String statusHood;
	// protected String statusSkyLight;
	// protected String statusTrunk;
	// protected String statusHeadLight;
	// Trouble CODE Requirement
	// protected Integer tirePressureLeftfrontStatus;
	// protected Integer tirePressureLeftrearStatus;
	// protected Integer tirePressureRightfrontStatus;
	// protected Integer tirePressureRightrearStatus;
	// protected String statusFarLight;
	// protected String statusNearLight;
	// protected String statusBlackLight;
	// protected String statusBrakeLight;
	// protected String statusBrumeLight;
	// protected String statusFrameLight;
	// protected String vehicleLock;
	// protected String brakeLining;
	// protected String engineOil;
	// protected String gearOil;
	// protected Integer totalMaf;
	protected Double airFlowRate;
	protected Integer intakeManifoldPressure;
	
	protected Integer engineDtcNumber;
	protected Integer oilPressure;
	protected Integer barometricPressure;
	protected Double longtermFuelTrim;
	
	protected Double sparkAngle;
	protected Integer totalFuelConsumption;
	protected Integer dashboardDistance;
	
	@Ignore
	protected String msgType; //"TIRE"胎压, "CAN"
	@Ignore
	protected Integer tpLeftfrontStatus;//左前胎压状态
	@Ignore
	protected Integer tpLeftrearStatus;//左后胎压状态
	@Ignore
	protected Integer tpRightfrontStatus;//右前胎压状态
	@Ignore
	protected Integer tpRightrearStatus; //右后胎压状态

	
	// protected Integer fuelPerHour;
	// protected Double instantFuelConsumption;



}
