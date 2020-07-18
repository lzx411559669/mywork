package com.bookcode.bookapireactive.Service.impl;

import com.bookcode.bookapireactive.Service.BookService;
import com.bookcode.bookapireactive.model.Book;
import com.bookcode.bookapireactive.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Flux<Book> findAll() {
        return bookRepository.findAll();
    }
    @Override
    public void delete(long id) {
        bookRepository.deleteById(id).subscribe();
    }

    @Override
    public void save(Book book) {
        bookRepository.findByIsbn(book.getIsbn()).hasElement().subscribe(founded -> {
            if (founded) {
                return;
            } else {
                bookRepository.save(book).subscribe();
            }
        });
    }
    @Override
    public Mono<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }
}
