package com.bookcode.r2dbcmysqlex.responsity;

import com.bookcode.r2dbcmysqlex.model.Account;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
@Repository
public interface AccountRepository extends ReactiveCrudRepository<Account, Integer> {
    @Query("SELECT * FROM account WHERE nick = :nick")
    Mono<Account> findByNick(String nick);
}