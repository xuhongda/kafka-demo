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

        Properties properties = ProducerProperties.getProducerPropertites();

        List<List<? extends Object>> list = new ArrayList<>();
        //list.add(createPeoples());
        list.add(ProducerPojo.createDeviceStatus());
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
}
