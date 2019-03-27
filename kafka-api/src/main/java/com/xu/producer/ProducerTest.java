package com.xu.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xu.pojo.People;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

/**
 * @author xuhongda on 2019/3/27
 * com.xu.producer
 * kafka-demo
 */
@Slf4j
public class ProducerTest {
    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "129.204.79.247:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
        final int num = 1000;
        for (int i = 0; i < num; i++) {
            String s = Integer.toString(i);
            People people = new People(i,"xuhongda");
            String ps = mapper.writeValueAsString(people);
            ProducerRecord<String, String> record = new ProducerRecord<>("my-topic", s, ps);
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
}
