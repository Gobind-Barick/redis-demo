package com.barick.redis_demo.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisListService {

    private final StringRedisTemplate stringRedisTemplate ;

    public RedisListService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public List<String> get (String key){

        return stringRedisTemplate.opsForList().range(key, 0  , -1) ;
    }

    public void add(String key ,  List<String> members) {

        stringRedisTemplate.opsForList().rightPushAll(key  , members) ;
    }

    public String  getLatest(String key){

       return stringRedisTemplate.opsForList().rightPop(key) ;
    }
}

