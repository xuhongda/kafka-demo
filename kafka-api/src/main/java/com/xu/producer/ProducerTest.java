package com.xu.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

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

    public static void main(String[] args)  {

        Properties properties = ProducerProperties.getProducerPropertites();
        sendToTopic(properties, ProducerPojo.createCreashDeviceStatus());
    }

    private static void sendToTopic(Properties properties, List list)  {

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);

        ExecutorService executorService = Executors.newFixedThreadPool(10);


        executorService.submit(() -> {

            log.info("处理线程 = {}", Thread.currentThread().getName());

            for (Object o : list) {

                kafka(kafkaProducer, o);

            }

        });

        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                //注意需要调用close 方法
                kafkaProducer.close();
                break;
            }
        }
    }

    private static void kafka(KafkaProducer<String, String> kafkaProducer, Object o) {

        String jsonStr = "";
        try {
            jsonStr = mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.info("context", e);
        }
        ProducerRecord<String, String> record = new ProducerRecord<>("device_status", jsonStr);
        String finalJsonStr = jsonStr;
        kafkaProducer.send(record, (RecordMetadata metadata, Exception exception) -> {
            if (exception == null) {
                log.info("kafka发送消息成功 = {}", finalJsonStr);
            } else {
                log.info("kafka 发送消息失败 = {} ; exception = {}", finalJsonStr,exception);
            }
        });

    }
}
