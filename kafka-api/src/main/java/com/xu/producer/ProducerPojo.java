package com.xu.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xu.pojo.DeviceStatus;
import com.xu.pojo.People;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author xuhongda on 2019/5/7
 * com.xu.producer
 * kafka-demo
 */
@Slf4j
public class ProducerPojo {

    private static ObjectMapper mapper = new ObjectMapper();



    public static DeviceStatus getDs() throws IOException {

        String json = "";

        return mapper.readValue(json, DeviceStatus.class);
    }


    /**
     * 车辆离线
     * @return list
     */
    public static List<DeviceStatus> createXx() {
        List<DeviceStatus> deviceStatusList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            DeviceStatus deviceStatus = new DeviceStatus();
            deviceStatus.setObjId("00011c590a024087962c18086824440a");
            deviceStatus.setDeviceId("30015200003");
            deviceStatus.setAlarmStatus((short) 46);
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
            deviceStatus.setAlarmStatus((short) 60);
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
            deviceStatus.setMultimediaEventCode("8");
            deviceStatus.setPosDirection(1);
            deviceStatus.setSoftwareVersion("GIDAG5040101");
            deviceStatus.setObjId("13090615385356367");
            deviceStatus.setDeviceId("2012521446");
            deviceStatus.setAlarmStatus((short) 6);
            deviceStatus.setPosSpeed(0);
            deviceStatus.setAccForward(5.0);
            deviceStatus.setAccSide(5.0);
            deviceStatus.setAccVerticle(5.0);
            deviceStatus.setPosLongitude(119.408152);
            deviceStatus.setPosLatitude(32.40865);
            deviceStatus.setMultimediaId("cff99f35-d2a8-4702-9054-449efeb34cda00000000000000");
            deviceStatus.setUpdateStatusTime(Timestamp.valueOf("2019-05-19 11:47:09.865"));
            deviceStatus.setVideoUrl("");
            Calendar instance = Calendar.getInstance();
            instance.add(Calendar.HOUR_OF_DAY,8);
            Date time = instance.getTime();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp timestamp = Timestamp.valueOf(format.format(time));
            deviceStatus.setPosTime(timestamp);
            log.info("postTime = {}", timestamp);
            deviceStatusList.add(deviceStatus);
        }
        return deviceStatusList;
    }

    /**
     * GPS 长时间不定位
     * @return list
     */
    public static List<DeviceStatus> createLongtermLocationStatus() {
        List<DeviceStatus> deviceStatusList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            DeviceStatus deviceStatus = new DeviceStatus();
            deviceStatus.setSoftwareVersion("GIDAG5040101");
            deviceStatus.setObjId("13090615385356367");
            deviceStatus.setDeviceId("14144539046");
            deviceStatus.setAlarmStatus((short) 8);
            deviceStatus.setPosSpeed(0);
            deviceStatus.setAccForward(8.0);
            deviceStatus.setAccSide(8.0);
            deviceStatus.setAccVerticle(8.0);
            deviceStatus.setPosLongitude(119.408152);
            deviceStatus.setPosLatitude(32.40865);
            deviceStatus.setMultimediaId("cff99f35-d2a8-4702-9054-449efeb34cda00000000000000");
            deviceStatus.setUpdateStatusTime(Timestamp.valueOf("2019-05-19 11:47:09.865"));

           /* Calendar instance = Calendar.getInstance();
            instance.add(Calendar.HOUR_OF_DAY,8);
            Date time = instance.getTime();*/
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp timestamp = Timestamp.valueOf(format.format(new Date()));
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
