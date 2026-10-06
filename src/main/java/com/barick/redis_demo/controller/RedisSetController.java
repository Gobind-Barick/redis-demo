package com.barick.redis_demo.controller;


import com.barick.redis_demo.service.RedisSetService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/redis/set")
public class RedisSetController {

    private final RedisSetService redisSetService ;


    public RedisSetController(RedisSetService redisSetService) {
        this.redisSetService = redisSetService;
    }

    @PostMapping("/roles/{userid}")
    public void addRoles(@PathVariable  String userid , @RequestBody String[] roles ){

        redisSetService.addRoles(userid , roles) ;
    }

    @GetMapping("/roles/{userid}")
    public Set<String> getRoles(@PathVariable String userid){

        return redisSetService.getRoles(userid);
    }
}
