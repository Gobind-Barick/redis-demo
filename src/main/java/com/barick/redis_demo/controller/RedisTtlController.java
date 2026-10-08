package com.barick.redis_demo.controller;

import com.barick.redis_demo.service.RedisTtlService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis/ttl")
public class RedisTtlController {

    private final RedisTtlService redisTtlService ;

    public RedisTtlController(RedisTtlService redisTtlService) {
        this.redisTtlService = redisTtlService;
    }

    @PostMapping("/create")
    public void createkeywithttl(@RequestParam String key  , @RequestParam String value , @RequestParam Long seconds ){

        redisTtlService.savewithttl(key,value ,  seconds);

    }

    @GetMapping("/get")
    public Long getttl(@RequestParam String key){

        return redisTtlService.getttl(key) ;
    }
}
