package com.bookcode.bookapi.service.impl;
import com.bookcode.bookapi.repository.BookRepository;
import com.bookcode.bookapi.model.Book;
import com.bookcode.bookapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public void delete(long id) {
        bookRepository.deleteById(id);
    }
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public List<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public Page<Book> page(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }


}
