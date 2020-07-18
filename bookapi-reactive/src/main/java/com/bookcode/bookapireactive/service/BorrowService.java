package com.bookcode.bookapireactive.service;

import com.bookcode.bookapireactive.model.Borrow;
import reactor.core.publisher.Mono;

public interface BorrowService {
    Mono<Borrow> findById(long id);
    void deleteBorrowBook(long bookId,long userId);
    void insertBorrowBook(Borrow borrow);
    void update(long userId,long bookId);
}
