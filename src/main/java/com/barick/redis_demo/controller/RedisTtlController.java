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



    @PostMapping("/generate-otp")
    public String generateOtp(@RequestParam String userId){

        return redisTtlService.generateotp(userId);
    }

    @PostMapping("verify-otp")
    public Boolean verifyOtp(@RequestParam String userId ,  @RequestParam String otp){

        return redisTtlService.verifyotp(userId, otp ) ;
    }
}
