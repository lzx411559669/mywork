package com.example.service;

import com.example.entity.User;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static Map<String, User> map = new HashMap<>();

    /**
     * 初始化几个测试用户
     */
    static {
        for (int i = 0; i < 10; i++) {
            map.put("admin" + i,new User("admin" + i,"password" + i));
        }
    }

    /**
     * 登录
     * @param user
     * @return
     */
    public static User login(User user){
        String username = user.getUsername();
        String password = user.getPassword();

        /**
         * 判断用户是否存在
         */
        if(StringUtils.isBlank(username) || !map.containsKey(username)){
            return null;
        }

        User result = map.get(username);

        /**
         * 判断密码是否正确
         */
        if(!result.getPassword().equals(password)){
            return null;
        }

        return result;
    }

}
