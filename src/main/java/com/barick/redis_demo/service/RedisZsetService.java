package com.barick.redis_demo.service;


import com.barick.redis_demo.model.ZsetPayload;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisZsetService {

    private final StringRedisTemplate stringRedisTemplate ;


    public RedisZsetService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public Boolean addScore (ZsetPayload payload ){

        return stringRedisTemplate.opsForZSet().add(payload.getKey() , payload.getMember() , payload.getScore()) ;


    }


    public Double  getScore (String key , String member ) {

        return stringRedisTemplate.opsForZSet().score(key , member) ;
    }
}
