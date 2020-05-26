package com.springboot.rabbitmqdemo;

import com.springboot.rabbitmqdemo.fanout.FanoutSender;
import com.springboot.rabbitmqdemo.many.Sender1;
import com.springboot.rabbitmqdemo.many.Sender2;
import com.springboot.rabbitmqdemo.simple.HelloSender;
import com.springboot.rabbitmqdemo.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Staro
 * @date: 2020/5/21 14:04
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {
    @Autowired
    private HelloSender helloSender;

    @Autowired
    private Sender1 sender1;

    @Autowired
    private Sender2 sender2;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void hello(){
        helloSender.send();
    }

    @Test
    public void oneToMany(){
        for (int i=0;i<10;i++){
            sender1.send(i);
        }
    }

    @Test
    public void manyToMany(){
        for (int i=0;i<10;i++){
            sender1.send(i);
            sender2.send(i);
        }
    }

    @Test
    public void topic(){
        topicSender.send();
        topicSender.send1();
        topicSender.send2();
    }

    @Test
    public void fanout(){
        fanoutSender.send();
    }

}
