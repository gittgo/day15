package com.example.springcloudkafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 */
@Component
public class KafkaConsumerListener {

    @KafkaListener(topics={"${kafka.topic}"})
    public void getMessage(String message) {
        System.out.println("kafka 消费者监听，接收到消息:" + message);
    }
}
