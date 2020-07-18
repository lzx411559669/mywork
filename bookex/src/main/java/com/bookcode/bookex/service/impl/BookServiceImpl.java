package com.bookcode.bookex.service.impl;
import com.bookcode.bookex.model.Book;
import com.bookcode.bookex.repository.BookRepository;
import com.bookcode.bookex.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Flux<Book> findAll() {
        return bookRepository.findAll();
    }
    @Override
    public void delete(long id) {
        bookRepository.deleteById(id).subscribe();
    }
    @Override
    public void save(Book book) {
        bookRepository.save(book).subscribe();
    }
    @Override
    public Mono<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }
}
