package com.example.springcloudstreamkafkademo.controller;


import com.example.springcloudstreamkafkademo.producer.MessageProducerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class StreamController {

    @Autowired
    private MessageProducerBean producerBean;

    @GetMapping("/send/smg")
    public boolean sendMsg(@RequestParam("message") String message){
        producerBean.send(message);
        return true;
    }

}
