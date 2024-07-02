package com.cv.rocketpsample.owntest;

import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.*;
import org.springframework.messaging.support.MessageBuilder;

public class SimpleReceive {


    public static void main(String[] args) {
        MessageChannel messageChannel = new DirectChannel();

        // Message subscription
        ((SubscribableChannel) messageChannel).subscribe(new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                System.out.println("receive msg: " + message.getPayload());
            }
        });

        // Message sending
        messageChannel.send(MessageBuilder.withPayload("simple msg").build());
    }

}
