package com.springboot.rabbitmqdemo.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Staro
 * @date: 2020/5/21 14:56
 * @Description:
 */
@Component
public class Sender1 {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int i) {
        String context = "queue" + " ****** " + i;
        System.out.println("Sender1:"+context);
        amqpTemplate.convertAndSend("many",context);
    }
}
