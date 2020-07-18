package com.bookcode.bookapireactive.Service;
import com.bookcode.bookapireactive.model.User;
import reactor.core.publisher.Mono;
public interface UserService {
  Mono<User> login(String username,String password);
}
