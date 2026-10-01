package com.barick.redis_demo.controller;

import com.barick.redis_demo.service.RedisStringService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisStringController {


    private final RedisStringService redisStringService ;

    public RedisStringController(RedisStringService redisStringService){
        this.redisStringService = redisStringService ;
    }

    @PostMapping("/set")
    public String set(@RequestParam String key  , @RequestParam String value){


        redisStringService.set(key , value);

        return "key saved successfully" ;
    }

    @GetMapping("/get")
    public String get(@RequestParam String key){

        return redisStringService.get(key) ;
    }

    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam String key){

        return redisStringService.delete(key) ;

    }

    @PostMapping("/exists")
    public Boolean exists(@RequestParam String key){

        return redisStringService.exists(key) ;
    }

}
