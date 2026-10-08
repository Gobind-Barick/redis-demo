package com.barick.redis_demo.controller;


import com.barick.redis_demo.model.ZsetPayload;
import com.barick.redis_demo.service.RedisZsetService;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/redis/zset")
public class RedisZestController {

    private final RedisZsetService redisZsetService ;

    public RedisZestController(RedisZsetService redisZsetService) {
        this.redisZsetService = redisZsetService;
    }


    @PostMapping("/add")
    public Boolean addScore(@RequestBody ZsetPayload Payload){

        return redisZsetService.addScore(Payload) ;


    }

    @GetMapping("/get/{key}/{member}")
    public Double  getScore(@PathVariable String key  , @PathVariable String member ){

        return redisZsetService.getScore(key , member) ;
    }

    @GetMapping("/get/{key}")
    public Set<ZSetOperations.TypedTuple<String>> top4 (@PathVariable  String key ){


        return redisZsetService.getTop4(key) ;
    }
}
