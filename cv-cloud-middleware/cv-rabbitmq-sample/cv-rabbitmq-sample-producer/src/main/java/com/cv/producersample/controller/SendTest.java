package com.cv.producersample.controller;

import com.cv.producersample.mq.producer.RabbitMqTestProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
@Order(1)
@Slf4j
public class SendTest  implements CommandLineRunner {


    @Resource
    private RabbitMqTestProducer rabbitMqTestProducer;


    @Override
    public void run(String... args) throws Exception {

        System.out.println("init ... ");

//        for (int i = 0; i < 10; i++) {
//            System.out.println("第"+i+"次发送...");
//            rabbitMqTestProducer.sendTestData(String.valueOf(i));
//        }
    }
}
