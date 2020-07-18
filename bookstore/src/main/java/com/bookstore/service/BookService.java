package com.bookstore.service;

import com.bookstore.model.Book;

import java.util.List;

public interface BookService {
    /**
     * 执行图书的保存
     * @param book
     */
    public void saveBook(Book book);

    /**
     * 获取所有图书
     * @return
     */
    public List<Book> getBooks();
    /**
     * 删除图示
     * @return
     */
    public void delBook(long bookId);

}

