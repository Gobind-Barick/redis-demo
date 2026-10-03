package com.barick.redis_demo.controller;


import com.barick.redis_demo.model.Book;
import com.barick.redis_demo.service.BookHashService;
import com.barick.redis_demo.service.BookRedisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis/hash")
public class BookHashController {

    private final BookHashService bookHashService;

    public BookHashController(BookHashService bookHashService) {
        this.bookHashService = bookHashService;
    }

    @PostMapping("/save")
    public void save(@RequestBody Book book){

        bookHashService.save(book);
    }

    @GetMapping("/fetch/{id}")
    public Book fetch(@PathVariable Long id ){

        return bookHashService.get(id);
    }

}
