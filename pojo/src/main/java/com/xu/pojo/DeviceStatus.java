package com.xu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * DeviceStatus entity. @author MyEclipse Persistence Tools
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeviceStatus implements java.io.Serializable {
    // ------------ Fields ------------
    // 通信网关的编号
    // protected String gateNo;

    protected String deviceId;
    // 设备绑定的上层应用的编号
    // protected String appId;
    protected String objId;
    // 设备的运行状态
    // protected Short serviceStatus;
    // 设备在线状态
    // protected Short onlineStatus;
    // 设备报警状态
    protected Short alarmStatus = 0;
    // 设备报警时间
    // protected Timestamp alarmTime;
    // protected Short posMethod;
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    protected Timestamp posTime;
    // protected Short posPrecision;
    protected Double posLongitude;
    protected Double posLatitude;
    protected Integer posAltitude;
    protected Integer posSpeed;
    // protected Integer posDirection;
    // protected String networkDataId;
    protected Double accForward = 0.0d;
    protected Double accSide = 0.0d;
    protected Double accVerticle = 0.0d;
    // protected Short rolloverLevel;
    // protected Timestamp rolloverReportTime;
    // protected Short voltageLevel;
    // protected Timestamp voltageReportTime;
    // protected Short collisionLevel;
    // protected Timestamp collisionReportTime;
    // protected Short signalLevel;
    // protected Timestamp signalReportTime;
    // protected Integer statusAreaMonitor;
    // protected String statushisId;
    // protected String statushisExtId;
    protected Double powerVoltage;
    // 设备的整个生命周期的状态
    // protected Integer deviceStatus = 1;
    // protected String gid;
    protected Short accStatus;
    // protected String brandId;
    // protected String gidVersion;
    // protected String dtcVersion;
    protected String softwareVersion;
    // protected String hardwareVersion;
    // protected String gsmType;
    // protected String bootloaderVersion;
    // protected Integer updateFlag;
    // protected String softwareDate;
    // protected String carType;
    // protected Short offlineEventType;
   // protected Timestamp updateStatusTime = new Timestamp(System.currentTimeMillis());

    private Integer duration;    // 事件持续时长(怠速)
    //add by mouwc 2015-05-14
    //gps表不存
    private String videoKey;    // 欧克兰项目要求
    //gps表不存
    private String videoUrl;    // 欧克兰项目要求

    private String multimediaId;    // 多媒体事件ID

    private String vin;

    private String vinReport;

    private String describe;

    private String satellites;//信号强度

    private Integer distanceTotal;//里程 米

}
