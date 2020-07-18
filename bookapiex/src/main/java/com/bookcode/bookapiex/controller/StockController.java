package com.bookcode.bookapiex.controller;

import com.bookcode.bookapiex.model.Stock;
import com.bookcode.bookapiex.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StockController {
    @Autowired
    private StockRepository stockRepository;
    @ResponseBody
    @RequestMapping("/getstocklist")
    public List<Stock> getStock(){
        return stockRepository.findAll();
    }
}
