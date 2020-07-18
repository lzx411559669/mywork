package com.bookcode.bookapi.service;
import com.bookcode.bookapi.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface BookService {
    //删除
    void delete(long id);
    //插入
    Book save(Book book);
    //查询
    List<Book> findAll();
    //根据书名查询
    List<Book> findByName(String name);
    Page<Book> page(Pageable pageable);
}
