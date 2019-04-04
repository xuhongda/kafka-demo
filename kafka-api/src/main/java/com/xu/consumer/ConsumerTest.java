package com.xu.consumer;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xu.pojo.DeviceStatus;
import com.xu.pojo.People;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
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
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Properties props = new Properties();
        /* 定义kafka 服务的地址，不需要将所有broker指定上 */
        //props.put("bootstrap.servers", "129.204.79.247:9092");
        props.put("bootstrap.servers", "datanode1:9092,datanode2:9092,datanode3:9092,datanode4:9092");
        /* 制定consumer group */
        props.put("group.id", "dae_ds_group");
        /* 是否自动确认offset */
        props.put("enable.auto.commit", "true");
        /* 自动确认offset的时间间隔 */
        props.put("auto.commit.interval.ms", "1000");
        /*coordinator 检测失败时间*/
        props.put("session.timeout.ms", "30000");
        /* key的序列化类 */
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        /* value的序列化类 */
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        /* 定义consumer */
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        /* 消费者订阅的topic, 可同时订阅多个 */
        consumer.subscribe(Collections.singletonList("device_status"));

        /* 读取数据，读取超时时间为100ms */
        //Duration java8 新的时间处理api
        Duration duration = Duration.ofSeconds(1);
        while (true) {
            //从kafka 角度来说 poll 就是成功消费消息
            ConsumerRecords<String, String> records = consumer.poll(duration);
            for (ConsumerRecord<String, String> record : records) {
                String value = record.value();
                DeviceStatus ds = JSON.parseObject(value, DeviceStatus.class);
              //  DeviceStatus ds = mapper.readValue(value, DeviceStatus.class);
                log.info("DeviceId = {}", ds.getDeviceId());
                System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
                log.info(value);
            }
        }
    }
}
