package com.barick.redis_demo.service;


import com.barick.redis_demo.model.Book;
import com.barick.redis_demo.utils.BookKeyUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class BookHashService {


    private final StringRedisTemplate stringRedisTemplate ;

    public BookHashService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;

    }

    public void save(Book book) {

    String key  = BookKeyUtil.bookKey(book.getId()) ;

    stringRedisTemplate.opsForHash().putAll(key , BookKeyUtil.toMap(book));

    }

    public Book get(Long id){


        Map<Object  , Object  > map = stringRedisTemplate.opsForHash().entries(BookKeyUtil.bookKey(id));

        return BookKeyUtil.fromMap(map) ;
    }
}
