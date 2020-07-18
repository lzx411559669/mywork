package com.example.springboot_login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {
    @RequestMapping(value = "/index")
    public String hello(){
        return "welcome";
    }


}
