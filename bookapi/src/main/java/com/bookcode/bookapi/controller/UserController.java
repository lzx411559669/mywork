package com.bookcode.bookapi.controller;

import com.bookcode.bookapi.model.User;
import com.bookcode.bookapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    /**
     *跳转登陆页面
     */
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/loginhtml")
    public String loginHtml(){
        return "/login";
    }
    /**
     * 登录
     */
    @RequestMapping(value = "/userlogin")
    public String login(String username, String password){
        if (userService.login(username,password) != null){
           return  "redirect:/book/list.html";
        }
        return "/login";
    }
    @ResponseBody
    @RequestMapping(value = "findall")
    public List<User> find(){
        return userService.findAll();
    }
}
