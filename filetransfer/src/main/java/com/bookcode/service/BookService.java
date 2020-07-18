package com.bookcode.service;

import com.bookcode.model.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;
import java.util.Map;
public interface BookService {
    double totalPrice(Flux<Book> flux);
    Flux<Book> sortByType(Flux<Book>flux,String type);
    Mono<List<Book>> sortByPrice(Flux<Book> flux);
    Mono<List<Book>> sortByTime(Flux<Book> flux);
    Flux<String> type(Flux<Book> flux);
    Map<String,Flux<Book>> toMap(Flux<Book> flux);
}
