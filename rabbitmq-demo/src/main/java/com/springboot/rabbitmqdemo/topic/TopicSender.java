package com.springboot.rabbitmqdemo.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Staro
 * @date: 2020/5/21 15:38
 * @Description:
 */
@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context="hi,i am message all";
        System.out.println("Sender:"+context);
        amqpTemplate.convertAndSend("exchange","topic.1",context);
    }

    public void send1(){
        String context="hi,i am message 1";
        System.out.println("Sender:"+context);
        amqpTemplate.convertAndSend("exchange","topic.message",context);
    }

    public void send2(){
        String context="hi,i am messages 2";
        System.out.println("Sender:"+context);
        amqpTemplate.convertAndSend("exchange","topic.messages",context);
    }
}
