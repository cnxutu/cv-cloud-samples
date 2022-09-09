package com.clearvision.producersample.controller;


import com.clearvision.producersample.mq.producer.RabbitMqTestProducer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/rabbitmq")
public class TestController {


    @Resource
    private RabbitMqTestProducer rabbitMqTestProducer;


    @RequestMapping(value = "/sendTest",method = RequestMethod.GET)
    public String sendTest(){

        for (int i = 0; i < 10; i++) {
            System.out.println("第"+i+"次发送...");
            rabbitMqTestProducer.sendTestData(String.valueOf(i));
        }

        return "";

    }



}
