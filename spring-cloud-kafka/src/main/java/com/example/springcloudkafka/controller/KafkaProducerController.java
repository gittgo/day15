package com.example.springcloudkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
public class KafkaProducerController {
    public final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;

    public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate,
                                   @Value("${kafka.topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @PostMapping("message/send") // 这种方式只支持post
    public boolean sendMessage(@RequestParam String message) {
        kafkaTemplate.send(topic,message);

        return true;
    }
}
