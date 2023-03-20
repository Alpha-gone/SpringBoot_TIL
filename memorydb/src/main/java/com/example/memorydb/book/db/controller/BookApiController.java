package com.example.memorydb.book.db.controller;

import com.example.memorydb.book.db.entity.BookEntity;
import com.example.memorydb.book.db.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookApiController {
    private final BookService bookService;

    @PostMapping("")
    public BookEntity create(@RequestBody BookEntity bookEntity){
        return bookService.create(bookEntity);
    }

    @GetMapping("/id/{id}")
    public BookEntity findById(@PathVariable Long id){
        return bookService.findById(id);
    }

    @GetMapping("/all")
    public List<BookEntity> findAll(){
        return bookService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }
}
