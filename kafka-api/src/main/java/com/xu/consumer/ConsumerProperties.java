package com.xu.consumer;

import java.util.Properties;

/**
 * @author xuhongda on 2019/5/7
 * com.xu.consumer
 * kafka-demo
 */
public class ConsumerProperties {

    public static Properties getConsumerProperties() {
        Properties props = new Properties();
        /* 定义kafka 服务的地址，不需要将所有broker指定上 */
       // props.put("bootstrap.servers", "192.168.234.130:9092");
        // props.put("bootstrap.servers", "129.204.79.247:9092");
        // props.put("bootstrap.servers", "datanode1:9092,datanode2:9092,datanode3:9092,datanode4:9092");
        props.put("bootstrap.servers", "172.20.1.103:9092,172.20.1.104:9092,172.20.1.105:9092,172.20.1.106:9092");
        /* 制定consumer group */
        //  props.put("group.id", "dae_ds_group");
        props.put("group.id", "testGroup");
        /* 是否自动确认offset */
        props.put("enable.auto.commit", "true");
        /* 自动确认offset的时间间隔 */
        props.put("auto.commit.interval.ms", "1000");
        /*coordinator 检测失败时间*/
        props.put("session.timeout.ms", "30000");
        /* key的序列化类 */
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        /* value的序列化类 */
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }
}
