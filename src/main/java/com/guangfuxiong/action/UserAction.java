package com.guangfuxiong.action;

import com.guangfuxiong.service.UserService;

public class UserAction {

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
