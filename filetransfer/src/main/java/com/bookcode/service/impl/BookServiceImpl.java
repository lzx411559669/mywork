package com.bookcode.service.impl;
import com.bookcode.model.Book;
import com.bookcode.service.BookService;
import org.junit.Test;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    double sum;
    //所有图书总价
    public double totalPrice(Flux<Book> flux) {
        sum=0;
        flux.subscribe(book -> {
            sum += book.getPrice();
        });
        return sum;
    }
    //根据分类查询
    public Flux<Book> sortByType(Flux<Book> flux,String type) {
       Flux<Book> types = flux.filter(book ->book.getType().contains(type));
         return types;
    }
    //根据分类分组
    public Map<String,Flux<Book>> toMap(Flux<Book> flux){
        Map<String,Flux<Book>> map= new HashMap<>();
       Flux<String> stringFlux = type(flux);
        stringFlux.subscribe(s -> {
            map.put(s,sortByType(flux,s));
        });
       return map;
    }
    //获取所有图书分类
    public Flux<String> type(Flux<Book> flux){
        List<String> types = new ArrayList<>();
        flux.subscribe(book -> {
           if ( !types.contains(book.getType())) {
               types.add(book.getType());
           }
        });
       return Flux.fromIterable(types);
    }
    @Override
    //按价格升序排列
    public Mono<List<Book>> sortByPrice(Flux<Book> flux) {
        return flux.collectSortedList(Comparator.comparing(Book::getPrice));
    }
    public Mono<List<Book>> sortByTime(Flux<Book> flux) {
        return flux.collectSortedList(Comparator.comparing(Book::getPublishDate));
    }
}
