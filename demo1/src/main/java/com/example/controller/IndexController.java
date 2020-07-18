package com.example.controller;

import com.example.entity.User;
import com.example.service.UserManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.WebSession;

@Controller
public class IndexController {


    /**
     * 跳转登录页面
     * @return
     */
    @GetMapping("login")
    public String login(){
        return "login";
    }

    /**
     * 表单提交路径以及方法
     * @param user
     * @param model
     * @param session
     * @return
     */
    @PostMapping("login")
    public String login(User user, Model model, WebSession session){
        User result = UserManager.login(user);
        if(result == null){
            model.addAttribute("message","用户名密码输入有误!");
            model.addAttribute("username",user.getUsername());
            return "login";
        }
        session.getAttributes().put("user",result);
        /**
         * 重定向
         */
        return "redirect:/success";
    }

    /**
     * 登录成功重定向地址
     * @return
     */
    @GetMapping("success")
    public String success(){
        return "success";
    }
}
