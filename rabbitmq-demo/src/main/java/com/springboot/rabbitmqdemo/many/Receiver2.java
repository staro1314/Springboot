package com.springboot.rabbitmqdemo.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: Staro
 * @date: 2020/5/21 14:59
 * @Description:
 */
@Component
@RabbitListener(queues = "many")
public class Receiver2 {

    @RabbitHandler
    public void process(String msg){
        System.out.println("receiver 2:"+msg);
    }
}
