package com.barick.redis_demo.controller;

import com.barick.redis_demo.service.RedisStringService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/redis")
public class RedisStringController {


    private final RedisStringService redisStringService ;

    public RedisStringController(RedisStringService redisStringService){
        this.redisStringService = redisStringService ;
    }



//    @PostMapping("/set")
//    public String set(@RequestParam String key  , @RequestParam String value){
//
//
//        redisStringService.set(key , value);
//
//        return "key saved successfully" ;
//    }

    @PostMapping("/set")
    public String set(@RequestBody HashMap<String,String> map ){

        redisStringService.mset(map);
        return "Key Saved Successfully" ;
    }


//    @GetMapping("/get")
//    public String get(@RequestParam String key){
//
//        return redisStringService.get(key) ;
//    }

    @GetMapping("/get")
    public List<String> get(@RequestBody List<String> keyset){

        return redisStringService.mget(keyset) ;
    }

    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam String key){

        return redisStringService.delete(key) ;

    }

    @PostMapping("/exists")
    public Boolean exists(@RequestParam String key){

        return redisStringService.exists(key) ;
    }

    @PostMapping("/increment")
    public Long increment(@RequestParam String key , @RequestParam(required = false,defaultValue = "1") Long value){

        return redisStringService.increment(key , value) ;

    }



}
