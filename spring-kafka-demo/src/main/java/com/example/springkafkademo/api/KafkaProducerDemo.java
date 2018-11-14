package com.example.springkafkademo.api;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * 生产者
 */
public class KafkaProducerDemo {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.1.150:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        String topic = "message";
        Integer partition = 0;
        long timeMillis = System.currentTimeMillis();
        String key = "key-message";
        String value = "value-message";
        ProducerRecord record = new ProducerRecord(topic, partition, key, value);
        kafkaProducer.send(record);
        kafkaProducer.close();

    }
}
