package com.dubbo.service.impl;

import com.dubbo.service.IHelloService;

public class HelloService2Impl implements IHelloService{

    @Override
    public String say(String name) {
        return "你好，"+name;
    }
}
