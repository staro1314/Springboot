package com.springboot.rabbitmqdemo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author: Staro
 * @date: 2020/5/21 13:56
 * @Description:
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue() {
        return new Queue("hello");
    }

    @Bean
    public Queue manyQueue() {
        return new Queue("many");
    }
}

