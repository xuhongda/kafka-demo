package com.xu.producer;

import java.util.Properties;

/**
 * @author xuhongda on 2019/5/7
 * com.xu.producer
 * kafka-demo
 */
public class ProducerProperties {

    public static Properties getProducerPropertites() {
        Properties properties = new Properties();
      // properties.put("bootstrap.servers", "192.168.234.130:9092,192.168.234.130:9093,192.168.234.130:9094");
     //  properties.put("bootstrap.servers", "192.168.1.223:9092");
        //properties.put("bootstrap.servers", "172.20.1.103:9092,172.20.1.104:9092,172.20.1.104:9092");
        properties.put("bootstrap.servers", "172.20.1.103:9092,172.20.1.104:9092,172.20.1.105:9092,172.20.1.106:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        return properties;
    }
}
