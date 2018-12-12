package com.guangfuxiong.springjdbc.servlet;

import com.guangfuxiong.springjdbc.pojo.User;
import com.guangfuxiong.springjdbc.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserServlet {
    @Resource
    private UserService userService;
    public void addUser(User user){
        userService.addUser(user);
    }
}
