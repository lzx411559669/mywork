package com.bookcode.userex.service;

import com.bookcode.userex.model.User;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> login(String username,String password);
    void save(User user);
}
