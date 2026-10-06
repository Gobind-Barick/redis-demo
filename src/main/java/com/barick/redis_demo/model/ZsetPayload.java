package com.barick.redis_demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZsetPayload {


    private String key ;
    private String member ;
    private Double score ;


}
