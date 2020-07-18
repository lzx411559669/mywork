package com.bookcode.bookapiex.service;

import com.bookcode.bookapiex.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookServive {
    List<Book> findById(Iterable<Long> booids);
    void SaveAll(List<Book> bookList,long stockId);
    List<Book> findAll();
    Page<Book> bookPage(Pageable pageable);
    List<Book> canBorrow();
    List<Book> findByType(String type);
    List<Book> getNewBook(int timeDays);
    List<Book> findByBookName(String bookName);
    void Save(Book book,long stcokId);
}
