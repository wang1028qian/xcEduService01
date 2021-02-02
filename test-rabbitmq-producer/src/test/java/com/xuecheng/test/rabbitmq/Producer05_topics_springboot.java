package com.xuecheng.test.rabbitmq;/*
 @author WangQ
 @DESCRIPTION ${DESCRIPTION}
 @create 2019/4/28
*/

import com.xuecheng.test.rabbitmq.config.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Producer05_topics_springboot {
    @Autowired
    RabbitTemplate rabbitTemplate;
    //使用rabbitTemplate发送消息
    @Test
    public void testSendEmail(){
        String message = "send email message to user";
        /**
         * 参数
         * 1，交换机
         * 2，routingKey
         * 3,消息内容
         */
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_TOPICS_INFORM,"inform.email",message);
    }
}