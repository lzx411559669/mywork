package com.bookcode.bookapireactive.Service;

import com.bookcode.bookapireactive.model.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
    Flux<Book> findAll();
    void delete(long id);
    void save(Book book);
    Mono<Book> findByName(String name);
}
