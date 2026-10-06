package com.barick.redis_demo.utils;

public class SetUtils {

    public static String rolesKey(String userId){

        return "user:" + userId + ":roles" ;
    }
}
