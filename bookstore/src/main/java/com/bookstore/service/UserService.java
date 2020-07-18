package com.bookstore.service;

import com.bookstore.model.User;

import java.util.List;

/**
 * 用户服务
 */
public interface UserService {

        /**
         * 执行用户的保存
         * @param user
         */
        public void saveUser(User user);

        /**
         * 获取所有用户
         * @return
         */
        public List<User> getUsers();
}
