package com.guangfuxiong.proxy.aop.server.impl;

import com.guangfuxiong.proxy.aop.server.UserService;
import com.guangfuxiong.proxy.proxy.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
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
