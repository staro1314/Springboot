package com.springboot.rabbitmqdemo.simple;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Staro
 * @date: 2020/5/21 13:58
 * @Description:
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context="hello";
        System.out.println("sender: "+context);
        rabbitTemplate.convertAndSend("hello",context);
    }
}
