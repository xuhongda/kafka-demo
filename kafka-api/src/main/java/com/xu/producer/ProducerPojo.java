package com.xu.producer;

import com.xu.pojo.DeviceStatus;
import com.xu.pojo.People;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xuhongda on 2019/5/7
 * com.xu.producer
 * kafka-demo
 */
@Slf4j
public class ProducerPojo {


    /**
     * 创建 DeviceStatus List 集合
     *
     * @return List
     */
    public static List<DeviceStatus> createDeviceStatus() {
        List<DeviceStatus> deviceStatusList = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            DeviceStatus deviceStatus = new DeviceStatus();
            deviceStatus.setObjId("LGBH52E01HY349442");
            deviceStatus.setDeviceId("30015200003");
            deviceStatus.setAlarmStatus((short) 31);
            deviceStatus.setDescribe("0");
            deviceStatus.setOfflineEventType((short) 2);
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp timestamp = Timestamp.valueOf(format.format(date));
            deviceStatus.setPosTime(timestamp);
            log.info("postTime = {}", timestamp);
            deviceStatusList.add(deviceStatus);
        }


        return deviceStatusList;
    }


    public static List<DeviceStatus> createCreashDeviceStatus() {
        List<DeviceStatus> deviceStatusList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            DeviceStatus deviceStatus = new DeviceStatus();
            deviceStatus.setObjId("13091404003681717");
            deviceStatus.setDeviceId("14144539046");
            deviceStatus.setAlarmStatus((short) 6);
            deviceStatus.setPosSpeed(0);
            deviceStatus.setAccForward(0.3);
            deviceStatus.setAccSide(1.0);
            deviceStatus.setAccVerticle(-0.0);
            deviceStatus.setUpdateStatusTime(Timestamp.valueOf("2019-05-19 10:14:06.613"));
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp timestamp = Timestamp.valueOf(format.format(date));
            deviceStatus.setPosTime(timestamp);
            log.info("postTime = {}", timestamp);
            deviceStatusList.add(deviceStatus);
        }
        return deviceStatusList;
    }

    public static List<People> createPeoples() {
        List<People> peopleList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            People people = new People();
            people.setAge(18);
            people.setName("xu");
            peopleList.add(people);
        }
        return peopleList;
    }
}
