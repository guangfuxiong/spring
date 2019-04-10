package com.dubbo.service.impl;

import com.dubbo.service.IHelloService;

public class HelloServiceImpl implements IHelloService {
    @Override
    public String say(String name) {
        return "hello "+name;
    }
}
