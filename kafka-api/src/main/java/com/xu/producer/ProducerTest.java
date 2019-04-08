package com.xu.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xu.pojo.DeviceStatus;
import com.xu.pojo.People;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuhongda on 2019/3/27
 * com.xu.producer
 * kafka-demo
 */
@Slf4j
public class ProducerTest {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {

        Properties properties = new Properties();
        //properties.put("bootstrap.servers", "129.204.79.247:9092,129.204.79.247:9093");
        properties.put("bootstrap.servers", "172.20.1.103:9092,172.20.1.104:9092,172.20.1.104:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(()-> {
            try {
                sendToTopic(properties);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();

    }

    private static void sendToTopic(Properties properties) throws JsonProcessingException {

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);

        List<DeviceStatus> deviceStatus = createDeviceStatus();
        for (int i = 0; i < deviceStatus.size(); i++) {
            String s = Integer.toString(i);
            String ds = mapper.writeValueAsString(deviceStatus.get(i));
            ProducerRecord<String, String> record = new ProducerRecord<>("device_status", s, ds);
            kafkaProducer.send(record, (RecordMetadata metadata, Exception exception) -> {
                if (exception == null) {
                    log.info("kafka" + s + " 发送消息成功");
                } else {
                    log.info("kafka" + s + " 发送消息失败");
                }
            });
        }

        kafkaProducer.close();

    }

    private static List<DeviceStatus> createDeviceStatus() {
        List<DeviceStatus> deviceStatusList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            DeviceStatus deviceStatus = new DeviceStatus();
            deviceStatus.setDeviceId("399666020035");
            deviceStatusList.add(deviceStatus);
        }
        return deviceStatusList;
    }
}
