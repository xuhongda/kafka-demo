package com.xu.kafkaspring.producer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda on 2019/5/8
 * com.xu.kafkaspring.producer
 * kafka-demo
 */
@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "xx")
    public void consumer(ConsumerRecord record) {
        System.out.println(record.key());
        System.out.println(record.value());
    }
}
