package com.bookcode.bookapireactive.service.impl;

import com.bookcode.bookapireactive.model.Stock;
import com.bookcode.bookapireactive.repository.StockRepository;
import com.bookcode.bookapireactive.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepository stockRepository;

    public Mono<Stock> get(long stockId){
       return stockRepository.findById(stockId);
    }

    public void insert(Stock stock){
        stockRepository.save(stock);
    }
}
