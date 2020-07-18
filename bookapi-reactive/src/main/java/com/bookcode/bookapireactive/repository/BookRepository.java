package com.bookcode.bookapireactive.repository;

import com.bookcode.bookapireactive.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BookRepository extends ReactiveCrudRepository<Book,Long> {
    @Override
    Flux<Book> findAllById(Iterable<Long> iterable);
    @Query(value = "select * from book where title like concat('%',:title,'%')")
    Flux<Book> findByTitleLike(@Param("title") String title);
    @Query(value = "select * from book where catalog like concat('%',:catalog,'%')")
    Flux<Book> findByCatalogLike(@Param("title") String catalog);
    @Query(value = "select * from book")
    Flux<Book> page(Pageable pageable);

}
