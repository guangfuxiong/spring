package com.dubbo.service.impl;

import com.dubbo.service.IHelloService;

public class HelloService1Impl implements IHelloService{

    @Override
    public String say(String name) {
        return "嗨，"+name;
    }
}
