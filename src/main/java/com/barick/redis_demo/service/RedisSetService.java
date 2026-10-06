package com.barick.redis_demo.service;

import com.barick.redis_demo.utils.SetUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RedisSetService {

private final StringRedisTemplate redisTemplate ;

    public RedisSetService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }




    public Long  addRoles(String userId , String... roles){

    return redisTemplate.opsForSet().add(SetUtils.rolesKey(userId) , roles ) ;

    }

    public Set<String> getRoles(String userId){

            return redisTemplate.opsForSet().members(SetUtils.rolesKey(userId)) ;
    }

}
