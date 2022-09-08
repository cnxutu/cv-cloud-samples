package com.clearvision.producersample.mq.producer;

import com.clearvision.producersample.common.constants.RmqConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tx
 * @date 2021/4/13 09:23
 */
@Service
@Slf4j
public class RabbitMqTestProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendTestData(String s) {
        rabbitTemplate.convertAndSend(RmqConstant.TOPIC_EXCHANGE_TEST,
                RmqConstant.ROUTING_KEY_TEST,
                s);
    }

}
