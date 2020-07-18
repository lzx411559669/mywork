package com.bookcode.r2dbcmysqlex.service;

import com.bookcode.r2dbcmysqlex.model.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface AccountService {
    Flux<Account> findAll();
    Mono<Integer> updatePassword(Integer id, String newPassword);
}
