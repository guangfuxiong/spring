package com.guangfuxiong.proxy.proxy.web;

import com.guangfuxiong.proxy.proxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserSevlet {
    @Autowired
    UserService userService;//注入的是代理对象
    public void addUser(){
        userService.addUser();
    }
    public void updateUser(){
        userService.updateUser();
    }
}
