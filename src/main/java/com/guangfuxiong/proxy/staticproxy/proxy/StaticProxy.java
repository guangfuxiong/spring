package com.guangfuxiong.proxy.staticproxy.proxy;

import com.guangfuxiong.proxy.staticproxy.service.UserService;
import com.guangfuxiong.proxy.staticproxy.tx.TransactionManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")//使代理看起来跟业务一样
public class StaticProxy implements UserService {
    @Autowired
    UserService userService;
    @Autowired
    TransactionManage tx;
    @Override
    public void addUser() {
        tx.begin();
        userService.addUser();
        tx.commit();
    }

    @Override
    public void updateUser() {
        tx.begin();
        userService.updateUser();
        tx.rollback();
    }
}
