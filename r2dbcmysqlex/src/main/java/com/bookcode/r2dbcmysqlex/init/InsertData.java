package com.bookcode.r2dbcmysqlex.init;

import com.bookcode.r2dbcmysqlex.model.Account;
import com.bookcode.r2dbcmysqlex.responsity.AccountRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.time.LocalDateTime;
@Component
public class InsertData implements ApplicationRunner {
    @Resource
    AccountRepository accountRepository;
    public void run(ApplicationArguments args) {
        accountRepository.findByNick("005").hasElement().subscribe(founded -> {
            if (!founded) {
                LocalDateTime now = LocalDateTime.now();
                Account account = new Account();
                account.setEmail("zhangsan@gmail.com");
                account.setNick("zhangsanfeng");
                account.setPassword("123456");
                account.setPhone("13987654321");
                account.setCreatedAt(now);
                account.setUpdatedAt(now);
                accountRepository.save(account).subscribe();
                System.out.println("成功导入一条记录（一个账号）信息。");
            }
        });
    }
}