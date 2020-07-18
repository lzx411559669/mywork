package com.bookcode.bookapiex.service;

import com.bookcode.bookapiex.model.Stock;

import java.util.List;

public interface StockService  {
    List<Stock> getStockList();
    public void add(Stock stock);
}
