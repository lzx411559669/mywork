package com.bookcode.bookapiex.repository;

import com.bookcode.bookapiex.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    @Override
    List<Stock> findAll();
    Stock findById(long stockId);
}
