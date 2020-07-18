package com.example.springboot_login.service;

import com.example.springboot_login.dao.UserMapper;
import com.example.springboot_login.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class UserLoginService implements UserMapper{
    /**
     * 注入dao
     */
    @Autowired
    private UserMapper usermapper;

    @Override
    public User userlogin(String username, String password) {

        User user = usermapper.userlogin(username,password);
        return user;
    }

    public int adduser(String username, String password, String sex){


        return usermapper.adduser(username,password,sex);
        //return usermapper.adduser1(username,password,age);     //对应sql语句中的第二种注册方式
    }

    @Override
    public int adduser1(String username, String password, String sex) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }


}
