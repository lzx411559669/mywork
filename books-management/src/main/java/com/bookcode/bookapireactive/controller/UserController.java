package com.bookcode.bookapireactive.controller;

import com.bookcode.bookapireactive.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    /**
     *跳转登陆页面
     */
    @RequestMapping(value = "/loginhtml")
    public String loginHtml(){
        return "/login";
    }
    /**
     * 登录
     */
    @RequestMapping("/userlogin")
    public String login(String username,String password){
        if (userService.login(username,password)!=null){
            return "redirect:/book/list.html";
        }
        return "/login";
    }
}
