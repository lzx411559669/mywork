package com.bookcode.userex.repository;

import com.bookcode.userex.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
@Repository
public interface UserRepository extends ReactiveMongoRepository<User,Integer> {
    Mono<User> findByUsernameAndPassword(String username,String password);
}
