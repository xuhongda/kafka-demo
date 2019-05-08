package com.xu.kafkaspring.producer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author xuhongda on 2019/5/8
 * com.xu.kafkaspring.producer
 * kafka-demo
 */
@Service

public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(cron = "0/5 * * * * ?")
    public void send() {
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send("xx", "hello");
        send.addCallback(o -> System.out.println("success"), throwable -> System.out.println("error"));
    }


}
