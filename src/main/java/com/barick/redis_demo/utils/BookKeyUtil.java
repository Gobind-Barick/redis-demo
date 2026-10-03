package com.barick.redis_demo.utils;

import com.barick.redis_demo.model.Book;

import java.util.HashMap;
import java.util.Map;

public class BookKeyUtil {

    public static String bookKey(Long id){

        return "hash:book"+id ;
    }

    public static HashMap<String , String > toMap(Book book){

    HashMap<String , String > map  = new HashMap<>() ;

    map.put("id" , String.valueOf(book.getId()) );
    map.put("title" , book.getTitle()) ;
    map.put("author" , book.getAuthor()) ;
    map.put("price" , book.getPrice()) ;

    return map ;
    }

    public static Book fromMap (Map<Object, Object> map ){

        return new Book (Long.valueOf(
                map.get("id").toString()),
                map.get("title").toString(),
                map.get("author").toString(),
                map.get("price").toString()
                ) ;

    }
}
