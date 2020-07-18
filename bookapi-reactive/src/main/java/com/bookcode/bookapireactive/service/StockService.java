package com.bookcode.bookapireactive.service;

import com.bookcode.bookapireactive.model.Stock;
import reactor.core.publisher.Mono;

public interface StockService {
    Mono<Stock> get(long stockId);
    void insert(Stock stock);
}
