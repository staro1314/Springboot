package com.springboot.rabbitmqdemo.simple;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: Staro
 * @date: 2020/5/21 14:03
 * @Description:
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {
    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver1: "+hello);
    }
}
