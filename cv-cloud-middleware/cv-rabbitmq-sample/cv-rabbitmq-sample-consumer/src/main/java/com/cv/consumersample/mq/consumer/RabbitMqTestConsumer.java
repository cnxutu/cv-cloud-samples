package com.cv.consumersample.mq.consumer;


import com.alibaba.fastjson.JSON;
import com.cv.consumersample.common.constants.RmqConstant;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author tx
 * @date 2021/09/18 09:23
 */
@Service
@Slf4j
public class RabbitMqTestConsumer {


    @RabbitListener(queues = RmqConstant.QUEUE_TEST)
    @Transactional(rollbackFor = Exception.class)
    public void queueParseImportExcelData(Message message, Channel channel) throws IOException {
        //1. start consumer
        log.info("开始消费......");
        String s = new String(message.getBody());
        if (StringUtils.isEmpty(s)) {
            // manual ack
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            return;
        }
        //2. handle business
        try {
            System.out.println("取出消息，内容为：" + s);
        } catch (Exception e) {
            log.info("数据解析出现异常 {}", e.getMessage());
            e.printStackTrace();
        } finally {
            // manual final ack
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            log.info("结束消费......");
        }
    }
}
