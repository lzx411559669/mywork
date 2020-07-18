package com.bookcode.bookapireactive.service;

import com.bookcode.bookapireactive.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> findById(long id);
    Mono<User> login(String userNumber,String password);
    Flux<User> userFlux();
    void save(User user);
    void update(User user);
    void delete(long userId);
}
