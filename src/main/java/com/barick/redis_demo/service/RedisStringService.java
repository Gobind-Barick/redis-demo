package com.barick.redis_demo.service;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

@Service
public class RedisStringService {


    private final RedisTemplate<String,String> redisTemplate ;

    private final StringRedisTemplate stringRedisTemplate ;

    public RedisStringService(RedisTemplate<String, String> redisTemplate, StringRedisTemplate stringRedisTemplate) {
        this.redisTemplate = redisTemplate;
        this.stringRedisTemplate = stringRedisTemplate;
    }


    public void set(String key , String value){

        redisTemplate.opsForValue().set(key , value) ;
    }

    public void mset(HashMap<String,String> msetmap){

        redisTemplate.opsForValue().multiSet(msetmap);
    }

    public void setwithexpiry(String key , String value  , Long duration ){

        redisTemplate.opsForValue().set(key , value , Duration.ofSeconds(duration));
    }


    public String get(String key){

        return  redisTemplate.opsForValue().get(key) ;
    }

    public List<String> mget(List<String> keyset){

        return  redisTemplate.opsForValue().multiGet(keyset) ;
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


    public Long getexpiry(String key) {
        return redisTemplate.getExpire(key) ;
    }

    public String setwithstringredistemplate(String key , String value ){
        stringRedisTemplate.opsForValue().set(key , value ) ;

        return "key saved successfully with stringredistemplate" ;
    }
}

