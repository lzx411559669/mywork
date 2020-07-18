package com.bookcode.bookex.repository;

import com.bookcode.bookex.model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
@Repository
public interface BookRepository extends ReactiveMongoRepository<Book,Long> {
    Mono<Book> findByName(String name);
}
