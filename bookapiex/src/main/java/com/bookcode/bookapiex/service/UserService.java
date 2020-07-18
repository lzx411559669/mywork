package com.bookcode.bookapiex.service;

import com.bookcode.bookapiex.model.Book;
import com.bookcode.bookapiex.model.Borrow;
import com.bookcode.bookapiex.model.User;

import java.util.List;

public interface UserService {
    User login(String userNumber,String password);
    void register(User user);
    void update(User user);
    void deleteAllByUserNum(List<Long> userNums);
    List<Book> getMyBook(User user);
    void borrowBook(User user, Borrow borrow, Book book);
    void returnBook(Long bookId);
}
