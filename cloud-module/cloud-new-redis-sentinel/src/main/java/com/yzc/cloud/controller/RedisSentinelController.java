package com.yzc.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: SanZ
 * @DATE: 2022/7/8 21:58
 */
@RestController
@RequestMapping("/redis")
public class RedisSentinelController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @GetMapping
    public void getRedis(String key){
        String s = stringRedisTemplate.opsForValue().get(key);
        System.out.println(s);
    }

    @GetMapping("/put")
    public void putRedis(String key,String value){
      stringRedisTemplate.opsForValue().set(key,value);
    }
}
