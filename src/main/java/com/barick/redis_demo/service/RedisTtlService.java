package com.barick.redis_demo.service;


import com.barick.redis_demo.utils.RedisTtlUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class RedisTtlService {

   private final StringRedisTemplate stringRedisTemplate ;

   Random random =new Random() ;

    public RedisTtlService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void savewithttl(String key  , String value ,  Long seconds){

        stringRedisTemplate.opsForValue().set(key , value , Duration.ofSeconds(seconds));

    }

    public Long getttl (String key){

        return stringRedisTemplate.getExpire(key , TimeUnit.SECONDS) ;
    }


    public String generateotp(String userId){
        String key  = RedisTtlUtils.createKey(userId) ;

        int  rawNumber  = random.nextInt(100000);

        String otp  =  String.format("%06d", rawNumber) ;


        stringRedisTemplate.opsForValue().set(key , otp  , Duration.ofMinutes(5));

        return otp ;

    }

    public boolean verifyotp (String userId ,  String otp){

        String key  = RedisTtlUtils.createKey(userId) ;

        String saved  = stringRedisTemplate.opsForValue().get(key) ;

        if(saved != null && saved.equals(otp) ){
            stringRedisTemplate.delete(saved);
            return true ;

        }
        return false ;


    }

}
