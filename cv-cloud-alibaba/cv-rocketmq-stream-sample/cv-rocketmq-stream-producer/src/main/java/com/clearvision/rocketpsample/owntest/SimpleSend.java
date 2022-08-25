package com.clearvision.rocketpsample.owntest;

import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.*;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

public class SimpleSend {

//    public static void main(String[] args) {
//        while (true) {
//            boolean result = source.poll(m -> {
//                String payload = (String) m.getPayload();
//                logger.info("Received: " + payload);
//                dest.send(MessageBuilder.withPayload(payload.toUpperCase())
//                        .copyHeaders(m.getHeaders())
//                        .build());
//            }, new ParameterizedTypeReference<String>() { });
//            if (result) {
//                logger.info("Processed a message");
//            }
//            else {
//                logger.info("Nothing to do");
//            }
//            Thread.sleep(5_000);
//        }
//    }


}
