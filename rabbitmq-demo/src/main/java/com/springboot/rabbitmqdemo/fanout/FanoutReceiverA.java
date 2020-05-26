package com.springboot.rabbitmqdemo.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: Staro
 * @date: 2020/5/21 16:04
 * @Description:
 */
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {

    @RabbitHandler
    public void process(String msg){
        System.out.println("Fanout receiver A:"+msg);
    }
}
