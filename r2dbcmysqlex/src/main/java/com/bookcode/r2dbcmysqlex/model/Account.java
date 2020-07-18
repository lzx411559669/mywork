package com.bookcode.r2dbcmysqlex.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;
@Table("account")
@Data
public class Account {
    @Id
    private Integer id;
    private String nick;
    private String email;
    private String phone;
    @Column("passwd")
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}