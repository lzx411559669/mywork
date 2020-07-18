package com.bookcode.bookapireactive.service;

import com.bookcode.bookapireactive.model.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
    Flux<Book> findAll(Iterable<Long> iterable);
    Mono<Book> findById(long id);
    Flux<Book> page(Flux<Book> bookFlux,int page,int size);
    Flux<Book> searchByTitle(String title);
    Flux<Book> getHotBooks();
    Flux<String> getCatalogs();
    Flux<Book> searchByCatalog(String catalog);
    void saveAllFromJson(String jsonContent);
    String getContentFromFile(String name);
    void update(Book book);
    void add(Book book);
    Mono<Long> getCount();
}
