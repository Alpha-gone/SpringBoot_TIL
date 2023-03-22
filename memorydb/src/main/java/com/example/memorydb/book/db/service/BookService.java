package com.example.memorydb.book.db.service;

import com.example.memorydb.book.db.entity.BookEntity;
import com.example.memorydb.book.db.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookEntity create(BookEntity bookEntity){
        return bookRepository.save(bookEntity);
    }

    public BookEntity findById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public List<BookEntity> findAll(){
        return bookRepository.findAll();
    }

    public void delete(Long id){
        bookRepository.deleteById(id);
    }
}
