package com.bookcode.bookapireactive.Service.impl;

import com.bookcode.bookapireactive.Service.UserService;
import com.bookcode.bookapireactive.model.User;
import com.bookcode.bookapireactive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Mono<User> login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }
}
