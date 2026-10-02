package com.barick.redis_demo.service;

import com.barick.redis_demo.model.Book;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookRedisService {

  private final RedisTemplate<String , Object> redisTemplate ;


  public BookRedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public void setBook (Book book) {

      String key  = "book:" + book.getId() ;

      redisTemplate.opsForValue().set(key , book);

    }

    public Book getBook (Long  id) {

        String key  = "book:" + id ;

        return (Book) redisTemplate.opsForValue().get(key);

    }


}
