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
import java.util.concurrent.*;

/**
 * @author xuhongda on 2019/3/27
 * com.xu.producer
 * kafka-demo
 */
@Slf4j
public class ProducerTest {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException, InterruptedException {

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "192.168.234.130:9092");
        //properties.put("bootstrap.servers", "129.204.79.247:9092");
        //properties.put("bootstrap.servers", "172.20.1.103:9092,172.20.1.104:9092,172.20.1.104:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);
        List<People> peoples = createPeoples();
        List<DeviceStatus> deviceStatus = createDeviceStatus();
        List<List<? extends Object>> list = new ArrayList<>();
        list.add(peoples);
        list.add(deviceStatus);
        sendToTopic(properties, list);
    }

    private static void sendToTopic(Properties properties, List<List<? extends Object>> objects) throws JsonProcessingException, InterruptedException {

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < objects.size(); i++) {
            executorService.submit(() -> {
                log.info("处理线程 = {}", Thread.currentThread().getName());
                String jsonStr = "";
                try {
                    jsonStr = mapper.writeValueAsString(objects);

                } catch (JsonProcessingException e) {
                    log.info("context", e);
                }
                ProducerRecord<String, String> record = new ProducerRecord<>("device_status", jsonStr);
                String finalJsonStr = jsonStr;
                kafkaProducer.send(record, (RecordMetadata metadata, Exception exception) -> {
                    if (exception == null) {
                        log.info("kafka发送消息成功 = {}", finalJsonStr);
                    } else {
                        log.info("kafka 发送消息失败 = {}", finalJsonStr);
                    }
                });
            });
        }
        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                //注意需要调用close 方法
                kafkaProducer.close();
                break;
            }
        }
    }

    private static List<DeviceStatus> createDeviceStatus() {
        List<DeviceStatus> deviceStatusList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            DeviceStatus deviceStatus = new DeviceStatus();
            deviceStatus.setDeviceId("399666020035");
            deviceStatusList.add(deviceStatus);
        }
        return deviceStatusList;
    }

    private static List<People> createPeoples() {
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
