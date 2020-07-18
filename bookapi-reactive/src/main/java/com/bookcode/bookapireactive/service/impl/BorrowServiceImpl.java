package com.bookcode.bookapireactive.service.impl;

import com.bookcode.bookapireactive.service.BorrowService;
import com.bookcode.bookapireactive.model.Borrow;
import com.bookcode.bookapireactive.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    @Override
    public Mono<Borrow> findById(long id) {
        return borrowRepository.findById(id);
    }

    @Override
    public void deleteBorrowBook(long bookId, long userId) {
        borrowRepository.deleteByBookIdAndAndUserId(bookId, userId);
    }

    /**
     * 插入borrow记录
     *
     * @param borrow
     */
    public void insertBorrowBook(Borrow borrow) {
        borrowRepository.findByBookIdAndUserId(borrow.getBookId(), borrow.getUserId()).hasElement().subscribe(founded -> {
            //如果存在则return
            if (founded) {
                return;
            } else {
                //不存在则插入
                borrowRepository.save(borrow).subscribe();
            }
        });

    }

    /**
     * 更新remarks
     *
     * @param userId
     * @param bookId
     */
    public void update(long bookId, long userId) {
        //borrowRepository.findByBookIdAndUserId(bookId, userId).subscribe(System.out::println);
        borrowRepository.findByBookIdAndUserId(bookId, userId).subscribe(borrow -> {
            //System.out.println("id:" + borrow.getBookId() + "remarks：" + borrow.getRemarks());
            borrow.setRemarks("0");
            borrowRepository.save(borrow).subscribe();
        });
    }
}
