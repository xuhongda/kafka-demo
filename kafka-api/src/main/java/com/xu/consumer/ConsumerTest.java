package com.xu.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuhongda on 2019/3/27
 * com.xu.consumer
 * kafka-demo
 */
@Slf4j
public class ConsumerTest {

    public static void main(String[] args) {

        Properties properties = ConsumerProperties.getConsumerProperties();
        /* 定义consumer */
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        /* 消费者订阅的topic, 可同时订阅多个 */
        consumer.subscribe(Arrays.asList("device_status","finance_alarm_msg","common_finance_alarm_msg","xxyyzz"));

        /* 读取数据，读取超时时间为100ms */
        //Duration java8 新的时间处理api
        Duration duration = Duration.ofSeconds(1);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        int num = 10;
        for (int i = 0; i < num; i++) {
            executorService.submit(() -> {
                while (true) {
                    //从kafka 角度来说 poll 就是成功消费消息
                    ConsumerRecords<String, String> records = consumer.poll(duration);
                    for (ConsumerRecord<String, String> record : records) {
                        String value = record.value();
                        System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
                        log.info("消费 = {}",value);
                    }
                }
            });

        }
    }
}
