package com.bookcode.userex.controller;
import com.bookcode.userex.model.User;
import com.bookcode.userex.service.UserService;
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
    @RequestMapping(value = "/login.html")
    public String loginHtml(){
        return "/login";
    }
    /**
     * 登录
     */
    @RequestMapping("/login")
    public String login(String username,String password){
        if (userService.login(username,password)!=null){
            return "redirect:http://localhost:8090/book/list.html";
        }
       return "/login";
    }
    /**
     *跳转注册页面
     */
    @RequestMapping("/add.html")
    public String add(){
        return "/add";
    }
    /**
     * 注册
     */
    @RequestMapping("/adduser")
    public String save(User user){
         userService.save(user);
         return "/login";
    }
}
