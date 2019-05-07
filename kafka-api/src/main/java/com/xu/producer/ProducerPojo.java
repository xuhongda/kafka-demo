package com.xu.producer;

import com.xu.pojo.DeviceStatus;
import com.xu.pojo.People;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongda on 2019/5/7
 * com.xu.producer
 * kafka-demo
 */
public class ProducerPojo {


    /**
     * 创建 DeviceStatus List 集合
     *
     * @return List
     */
    public static List<DeviceStatus> createDeviceStatus() {
        List<DeviceStatus> deviceStatusList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            DeviceStatus deviceStatus = new DeviceStatus();
            deviceStatus.setObjId("LGBH52E01HY349442");
            deviceStatus.setDeviceId("30015200003");
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
