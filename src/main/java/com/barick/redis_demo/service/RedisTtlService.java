package com.barick.redis_demo.service;


import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Service
public class RedisTtlService {

   private final StringRedisTemplate stringRedisTemplate ;

    public RedisTtlService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void savewithttl(String key  , String value ,  Long seconds){

        stringRedisTemplate.opsForValue().set(key , value , Duration.ofSeconds(seconds));

    }

    public Long getttl (String key){

        return stringRedisTemplate.getExpire(key , TimeUnit.SECONDS) ;
    }

}
