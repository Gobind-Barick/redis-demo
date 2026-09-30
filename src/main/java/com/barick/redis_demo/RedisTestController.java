package com.barick.redis_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {

    @Autowired
    RedisConnectionFactory redisConnectionFactory ;



    @GetMapping("/redis/test")
    public String redistest(){


        RedisConnection connection = redisConnectionFactory.getConnection() ;

        String response ;


        try {
            response = connection.ping();
        } finally {
            connection.close();
        }

    return response ;


    }


}
