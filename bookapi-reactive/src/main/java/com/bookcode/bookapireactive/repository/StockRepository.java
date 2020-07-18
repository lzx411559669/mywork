package com.bookcode.bookapireactive.repository;

import com.bookcode.bookapireactive.model.Stock;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface StockRepository extends ReactiveCrudRepository<Stock,Long>{
    @Override
    <S extends Stock> Mono<S> save(S s);

    @Override
    Mono<Stock> findById(Long aLong);
}
