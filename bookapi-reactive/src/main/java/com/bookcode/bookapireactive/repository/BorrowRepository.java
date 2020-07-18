package com.bookcode.bookapireactive.repository;

import com.bookcode.bookapireactive.model.Borrow;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BorrowRepository extends ReactiveCrudRepository<Borrow,Long> {

    Flux<Borrow> findAll();
    /**
     * 根据userId获取bookId
     * @param userId
     * @return
     */
    @Query(value = "select book_id from borrow where user_id =:userId and remarks = 1")
    Flux<Long> getBookId(@Param("userId")Long userId);

    /**
     * 根据bookId获取userId
     * @param bookId
     * @return
     */
    @Query(value = "select user_id from borrow where book_id =:bookId")
    Flux<Long> getUserId(@Param("bookId")Long bookId);

    /**
     * 删除
     * @param bookId
     * @param userId
     * @return
     */
    Mono<Void> deleteByBookIdAndAndUserId(long bookId,long userId);
    /**
     * 根据bookId，userId查找
     * @param bookId
     * @param userId
     * @return
     */
   // @Query(value = "select * from borrow where book_id =:bookId and user_id =:userId")
    Mono<Borrow> findByBookIdAndUserId(long bookId,long userId);

    @Override
    Mono<Boolean> existsById(Long aLong);

    //错误XX
    //Mono<Boolean> existsByBookIdAndUserId(Long BookId,Long userId);
}
