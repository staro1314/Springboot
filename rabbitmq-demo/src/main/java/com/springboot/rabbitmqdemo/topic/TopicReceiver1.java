package com.springboot.rabbitmqdemo.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: Staro
 * @date: 2020/5/21 15:45
 * @Description:
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver1 {

    @RabbitHandler
    public void process(String message){
        System.out.println("topic receiver1: "+message);
    }

}
