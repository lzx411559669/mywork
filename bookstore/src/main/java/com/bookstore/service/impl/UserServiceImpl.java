package com.bookstore.service.impl;

import com.bookstore.model.User;
import com.bookstore.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    public static List<User> userList = new ArrayList<>();

    @Override
    public void saveUser(User user) {
        userList.add(user);
    }

    @Override
    public List<User> getUsers() {
        return userList;
    }
}
