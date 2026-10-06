package com.barick.redis_demo.service;

import com.barick.redis_demo.utils.SetUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisSetService {

private final StringRedisTemplate redisTemplate ;

    public RedisSetService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }




    public Long  addRoles(String userId , String... roles){

    return redisTemplate.opsForSet().add(SetUtils.rolesKey(userId) , roles ) ;

    }

}
