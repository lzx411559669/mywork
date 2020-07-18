package com.bookcode.bookapireactive.repository;
import com.bookcode.bookapireactive.model.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
@Repository
public interface BookRepository extends ReactiveCrudRepository<Book,Long> {
    @Query("SELECT * FROM book WHERE isbn = :isbn")
    Mono<Book> findByIsbn(String isbn);
    @Query("SELECT * FROM book WHERE name =:name")
    Mono<Book> findByName(String name);
}
