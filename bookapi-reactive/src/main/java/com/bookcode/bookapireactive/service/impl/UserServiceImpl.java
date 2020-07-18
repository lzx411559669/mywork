package com.bookcode.bookapireactive.service.impl;

import com.bookcode.bookapireactive.service.UserService;
import com.bookcode.bookapireactive.model.User;
import com.bookcode.bookapireactive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public Mono<User> findById(long id) {
        return userRepository.findById(id);
    }
    @Override
    public Mono<User> login(String userNumber, String password) {
        return userRepository.findByUserNumberAndPassword(userNumber,password);
    }
    public void save(User user){
        userRepository.findByUserNumber(user.getUserNumber()).hasElement().subscribe(founded->{
            if (!founded){
                userRepository.save(user).subscribe();
            }
        });
    }
    public void update(User user){
        userRepository.save(user).subscribe();
    }
    @Override
    public Flux<User> userFlux() {
        return userRepository.findAll();
    }

    /**
     * 删除
     * @param userId
     * @return
     */
    public void delete(long userId){
        userRepository.deleteById(userId).subscribe();
    }
}
