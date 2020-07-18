package com.bookstore.service.impl;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private static int ID = 1;
    private final List<Book> bookLists = new ArrayList<>();

    @Override
    public void saveBook(Book book) {
        long id = ID++;
        book.setId(id);
        bookLists.add(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookLists;
    }

    @Override
    public void delBook(long bookId) {
        Iterator<Book> itr = bookLists.iterator();
        while (itr.hasNext()) {
            Book book = itr.next();
            if (book.getId() == bookId) {
                itr.remove();
            }
        }
    }
}