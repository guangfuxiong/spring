package com.guangfuxiong.springSSM.controller;

import com.guangfuxiong.springSSM.service.UserService;
import com.guangfuxiong.springSSM.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "findAll.do")
    public String findAll(Model model){
        List<User> list = userService.findAll();
        model.addAttribute("userList",list);
        return "springSSM/userList";
    }
}
