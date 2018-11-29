package com.zwj.user.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @program microservice
 * @description:
 * @author: wj
 * @create: 2018/11/14 18:32
 */
@Component
public class RedisClient {

    @Autowired
    private RedisTemplate redisTemplate;

    public  <T>T get(String key) {
        return (T)redisTemplate.opsForValue().get(key);
    }

    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key,value);
    }

    public void set(String key, Object value,Integer timeout) {
        redisTemplate.opsForValue().set(key,value,timeout, TimeUnit.SECONDS);
    }

    public void expire(String key,Integer timeout) {
        redisTemplate.expire(key,timeout,TimeUnit.SECONDS);
    }
}
