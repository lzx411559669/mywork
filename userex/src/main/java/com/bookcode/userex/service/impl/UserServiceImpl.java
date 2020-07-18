package com.bookcode.userex.service.impl;
import com.bookcode.userex.model.User;
import com.bookcode.userex.repository.UserRepository;
import com.bookcode.userex.service.UserService;
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
    @Override
    public void save(User user) {
         userRepository.save(user).subscribe();
    }
}
