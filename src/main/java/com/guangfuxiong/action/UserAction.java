package com.guangfuxiong.action;

import com.guangfuxiong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction {

    @Autowired
    UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        userService.addUser();
    }

}
