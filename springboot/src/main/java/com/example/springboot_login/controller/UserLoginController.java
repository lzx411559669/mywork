package com.example.springboot_login.controller;

import com.example.springboot_login.entity.User;
import com.example.springboot_login.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
public class UserLoginController{
    @Autowired
   private UserLoginService userLoginService;
    /**
     * 跳转到登陆页面
     */
    @RequestMapping(value = "/login.html")
    public String loginHtml(){
        return "login";
    }
    /**
     * 跳转到注册
     */
    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }
    /**
     * 跳转到用户注册页面
     * @return 注册页面
     */
    @RequestMapping(value = {"/registerpage"})
    public String registerpage(){
        return "register";
    }
    /**
     * 用户登陆
     */
    @RequestMapping(value = "userLogin")
    public String userLogin(@RequestParam ("username") String username,@RequestParam ("password") String password, HttpServletRequest request){
        System.out.println(username+password);
        User user =userLoginService.userlogin(username,password);
        //登陆成功
        if (user!=null){
           // request.getSession().setAttribute("session_user",user);     //将用户信息放入session
            return "index";
        }
        return "error";

    }
    /**
     * 注册新用户
     * @return 注册结果
     */
    @ResponseBody
    @RequestMapping(value = {"/uregister"})
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("password2") String password2,
                          @RequestParam("sex") String sex){

        if(!password.equals(password2)){

            return "两次密码不相同，注册失败！！";
        }else {
            int res = userLoginService.adduser(username,password,sex);
            if(res == 0){
                return "注册失败！";
            }else {
                return "注册成功！";
            }
        }

    }







}
