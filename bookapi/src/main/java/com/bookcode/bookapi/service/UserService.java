package com.bookcode.bookapi.service;

import com.bookcode.bookapi.model.User;

import java.util.List;

public interface UserService {
    //查询
    List<User> findAll();
    //插入
    User save(User user);
    //更新
    User update(User user);
    //删除
    void delete(int id);
    //登陆
    User login(String name,String password);
}
