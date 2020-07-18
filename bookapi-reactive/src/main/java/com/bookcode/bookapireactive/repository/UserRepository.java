package com.bookcode.bookapireactive.repository;

import com.bookcode.bookapireactive.model.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.ui.Model;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User,Long> {
    Mono<User> findByUserNumberAndPassword (@Param("userNumber")String userNumber,@Param("password")String password);


    Mono<User> findByUserNumber(String userNumber);

    @Override
    Mono<Void> deleteById(Long aLong);
}
