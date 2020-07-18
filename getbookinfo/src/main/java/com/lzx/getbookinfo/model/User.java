package com.lzx.getbookinfo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "user")
public class User {
    @Id
    private long id;
    private String userNumber;
    private String name;
    private String password;
    private String role;
    private String department;
    private String phone;
    private String email;
    @ManyToMany(mappedBy = "userList")
    private List<Book> bookList;
}
