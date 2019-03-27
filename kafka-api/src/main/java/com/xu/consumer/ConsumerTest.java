package com.xu.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xu.pojo.People;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @author xuhongda on 2019/3/27
 * com.xu.consumer
 * kafka-demo
 */
@Slf4j
public class ConsumerTest {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Properties props = new Properties();
        /* 定义kafka 服务的地址，不需要将所有broker指定上 */
        props.put("bootstrap.servers", "129.204.79.247:9092");
        /* 制定consumer group */
        props.put("group.id", "test");
        /* 是否自动确认offset */
        props.put("enable.auto.commit", "true");
        /* 自动确认offset的时间间隔 */
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        /* key的序列化类 */
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        /* value的序列化类 */
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        /* 定义consumer */
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        /* 消费者订阅的topic, 可同时订阅多个 */
        consumer.subscribe(Collections.singletonList("my-topic"));

        /* 读取数据，读取超时时间为100ms */

        try{
            while (true) {
                //Duration java8 新的时间处理api
                Duration duration = Duration.ofSeconds(1);
                ConsumerRecords<String, String> records = consumer.poll(duration);
                for (ConsumerRecord<String, String> record : records) {
                    String value = record.value();
                    People people = mapper.readValue(value, People.class);
                    log.info("age = {}", people.getAge());
                    System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
                }
            }
        }finally {
            consumer.close();
        }

    }
}
