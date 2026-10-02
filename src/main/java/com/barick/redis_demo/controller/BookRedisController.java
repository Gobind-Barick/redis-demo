package com.barick.redis_demo.controller;


import com.barick.redis_demo.model.Book;
import com.barick.redis_demo.service.BookRedisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis/book")
public class BookRedisController {

    private final BookRedisService bookRedisService ;

    public BookRedisController(BookRedisService bookRedisService) {
        this.bookRedisService = bookRedisService;
    }

    @PostMapping("/save")
    public void setBook (@RequestBody Book book){
        bookRedisService.setBook(book);

    }

    @GetMapping("/fetch/{id}")
    public Book getBook (@PathVariable  Long  id) {
      return  bookRedisService.getBook(id) ;
    }

}
