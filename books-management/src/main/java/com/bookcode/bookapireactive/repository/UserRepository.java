package com.bookcode.bookapireactive.repository;
import com.bookcode.bookapireactive.model.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
public interface UserRepository extends ReactiveCrudRepository<User,Integer> {
    @Query("SELECT FROM user WHERE username =:username AND password =:password")
    Mono<User> findByUsernameAndPassword(String username,String password);
}
