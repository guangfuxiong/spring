package com.guangfuxiong.proxy.staticproxy.web;

import com.guangfuxiong.proxy.staticproxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
