package com.guangfuxiong.proxy.aop.service.impl;

import com.guangfuxiong.proxy.aop.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }

    @Override
    public void updateUser() {
        System.out.println("更新用户");
    }

}
