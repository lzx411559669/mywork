package com.bookstore.control;

import com.bookstore.model.User;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserControl {
    @Autowired
    UserService userService;
    @GetMapping("/user/add.html")
    public String addUser(){
        return "user/addUser";
    }
    @PostMapping("/user/save")
    public String saveUser(@Valid User user, BindingResult error, Model model){
        if (error.hasErrors()){
            // 如果校验不通过，返回用户编辑页面
            return "user/addUser";
        }
        userService.saveUser(user);
        // 校验通过，返回list页面

        return "redirect:/user/list.html";
    }
    @GetMapping("/user/list.html")
    public String list(Model model){
        List<User> userList = userService.getUsers();
        model.addAttribute("userlist", userList);
        return "user/list";
    }

}
