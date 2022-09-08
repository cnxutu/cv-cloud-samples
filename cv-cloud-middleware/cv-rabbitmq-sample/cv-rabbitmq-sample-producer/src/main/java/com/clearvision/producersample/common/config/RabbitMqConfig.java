package com.clearvision.producersample.common.config;

import com.clearvision.producersample.common.constants.RmqConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class RabbitMqConfig {


    // 订阅模式 test
    @Bean(RmqConstant.QUEUE_TEST)
    public Queue queueDataReFlowScreened() {
        return new Queue(RmqConstant.QUEUE_TEST);
    }

    @Bean(RmqConstant.TOPIC_EXCHANGE_TEST)
    public Exchange topicExchangeDataReFlowScreened() {
        return ExchangeBuilder.topicExchange(RmqConstant.TOPIC_EXCHANGE_TEST).durable(true).build();
    }

    @Bean
    public Binding dataReFlowScreenedQueueBindingTopicExchange(
            @Qualifier(RmqConstant.QUEUE_TEST) Queue queue,
            @Qualifier(RmqConstant.TOPIC_EXCHANGE_TEST) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(RmqConstant.ROUTING_KEY_TEST).noargs();
    }


}
