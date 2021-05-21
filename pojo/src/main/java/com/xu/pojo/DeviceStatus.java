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
    // public String gateNo;
    protected String multimediaEventCode;
    public String deviceId;
    // 设备绑定的上层应用的编号
    // public String appId;
    public String objId;
    // 设备的运行状态
    // public Short serviceStatus;
    // 设备在线状态
    // public Short onlineStatus;
    // 设备报警状态
    public Short alarmStatus = 0;
    // 设备报警时间
    // public Timestamp alarmTime;
    // public Short posMethod;
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    public Timestamp posTime;
    // public Short posPrecision;
    public Double posLongitude;
    public Double posLatitude;
    public Integer posAltitude;
    public Integer posSpeed;
    public Integer posDirection;
    // public String networkDataId;
    public Double accForward = 0.0d;
    public Double accSide = 0.0d;
    public Double accVerticle = 0.0d;
    // public Short rolloverLevel;
    // public Timestamp rolloverReportTime;
    // public Short voltageLevel;
    // public Timestamp voltageReportTime;
    // public Short collisionLevel;
    // public Timestamp collisionReportTime;
    // public Short signalLevel;
    // public Timestamp signalReportTime;
    // public Integer statusAreaMonitor;
    // public String statushisId;
    // public String statushisExtId;
    public Double powerVoltage;
    // 设备的整个生命周期的状态
    // public Integer deviceStatus = 1;
    // public String gid;
    public Short accStatus;
    // public String brandId;
    // public String gidVersion;
    // public String dtcVersion;
    public String softwareVersion;
    // public String hardwareVersion;
    // public String gsmType;
    // public String bootloaderVersion;
    // public Integer updateFlag;
    // public String softwareDate;
    // public String carType;
    public Short offlineEventType;
    public Timestamp updateStatusTime = new Timestamp(System.currentTimeMillis());

    public Integer duration;    // 事件持续时长(怠速)
    //add by mouwc 2015-05-14
    //gps表不存
    public String videoKey;    // 欧克兰项目要求
    //gps表不存
    public String videoUrl;    // 欧克兰项目要求

    public String multimediaId;    // 多媒体事件ID

    public String vin;

    public String vinReport;

    public String describe;

    public String satellites;//信号强度

    public Integer distanceTotal;//里程 米

    private String msgType;

    /**
     *  UBI  精准碰撞角度
     */
    private Integer collisionAngle;


    /**
     * 碰撞类型：1、主动碰撞 2、被动碰撞
     */
    private Integer collisionType;

    /**
     *  碰撞因数
     */
    private Integer collisionFactor;

}
