package com.springboot.rabbitmqdemo.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Staro
 * @date: 2020/5/21 16:00
 * @Description:
 */
@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context="hi, fanout msg ";
        System.out.println("Sender: "+context);
        amqpTemplate.convertAndSend("fanoutExchange","",context);
    }
}
