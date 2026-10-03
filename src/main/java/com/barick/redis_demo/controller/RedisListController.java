package com.barick.redis_demo.controller;


import com.barick.redis_demo.service.RedisListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis/list")
public class RedisListController {

    private final RedisListService redisListService ;

    public RedisListController(RedisListService redisListService) {
        this.redisListService = redisListService;
    }

    @GetMapping("/get/{key}")
    public List<String> get(@PathVariable String key){
        return redisListService.get(key) ;
    }

    @GetMapping("/get/latest/{key}")
    public String getLatest(@PathVariable String key){
        return redisListService.getLatest(key) ;
    }

    @PostMapping("/add")
    public void add(@RequestParam String key , @RequestBody List<String> members){

        redisListService.add(key , members);

    }
}
