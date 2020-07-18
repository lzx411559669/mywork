package com.bookcode.r2dbcmysqlex.service.impl;

import com.bookcode.r2dbcmysqlex.model.Account;
import com.bookcode.r2dbcmysqlex.service.AccountService;
import org.springframework.data.domain.Sort;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.annotation.Resource;
import static org.springframework.data.domain.Sort.Order.desc;
@Repository
public class AccountServiceImpl implements AccountService {
    @Resource
    private DatabaseClient databaseClient;
    @Override
    public Flux<Account> findAll() {
        return databaseClient.select()
                .from(Account.class)
                .orderBy(Sort.by(desc("id")))
                .fetch()
                .all();
    }
    @Override
    public Mono<Integer> updatePassword(Integer id, String newPassword) {
        return databaseClient.execute("update account set passwd = $1 where id = $2")
                .bind("$1", newPassword)
                .bind("$2", id)
                .fetch()
                .rowsUpdated();
    }
}