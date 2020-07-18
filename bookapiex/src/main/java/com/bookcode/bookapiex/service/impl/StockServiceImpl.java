package com.bookcode.bookapiex.service.impl;

import com.bookcode.bookapiex.model.Book;
import com.bookcode.bookapiex.model.Borrow;
import com.bookcode.bookapiex.model.Stock;
import com.bookcode.bookapiex.repository.StockRepository;
import com.bookcode.bookapiex.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> getStockList() {
        return stockRepository.findAll();
    }
    public void add(Stock stock){
        stockRepository.save(stock);
    }

}
