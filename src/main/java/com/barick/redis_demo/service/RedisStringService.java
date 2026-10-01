package com.barick.redis_demo.service;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisStringService {


    private final RedisTemplate<String,String> redisTemplate ;

    public RedisStringService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public void set(String key , String value){

        redisTemplate.opsForValue().set(key , value) ;
    }

    public String get(String key){

        return  redisTemplate.opsForValue().get(key) ;
    }

    public boolean delete(String key){

        return redisTemplate.delete(key) ;
    }

    public boolean exists(String key){

        return redisTemplate.hasKey(key) ;
    }

    public Long increment (String key , Long value ){

        return redisTemplate.opsForValue().increment(key , value ) ;
    }




}

