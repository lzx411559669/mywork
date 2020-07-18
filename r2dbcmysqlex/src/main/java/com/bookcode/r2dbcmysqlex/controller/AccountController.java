package com.bookcode.r2dbcmysqlex.controller;

import com.bookcode.r2dbcmysqlex.model.Account;
import com.bookcode.r2dbcmysqlex.responsity.AccountRepository;
import com.bookcode.r2dbcmysqlex.service.AccountService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.annotation.Resource;
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;
    @Resource
    AccountRepository accountRepository;
    @RequestMapping("/accounts")
    public Flux<Account> allAccounts() {
        return accountService.findAll();
    }
    @RequestMapping("/account/{nick}")
    public Mono<Account> showAccountByNick(@PathVariable String nick) {
        return accountRepository.findByNick(nick);
    }
    @PostMapping("/account/update_passwd")
    public Mono<Integer> updatePassword(@Param(value = "id") Integer id, @Param(value = "id") String password) {
        return accountService.updatePassword(id, password);
    }
}