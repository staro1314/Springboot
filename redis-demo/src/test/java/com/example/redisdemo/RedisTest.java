package com.example.redisdemo;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Staro
 * @date: 2020/5/19 17:16
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void test(){
        redisTemplate.opsForValue().set("aaa","111");
        Assert.assertEquals("111",redisTemplate.opsForValue().get("aaa"));
        System.out.println(redisTemplate.opsForValue().get("aaa"));
    }
}
