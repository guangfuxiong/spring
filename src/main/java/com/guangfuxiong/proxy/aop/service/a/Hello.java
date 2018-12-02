package com.guangfuxiong.proxy.aop.service.a;

import org.springframework.stereotype.Component;

@Component
public class Hello {
    public void hello(){
        System.out.println("AOP好容易啊，好喜欢");
    }
}
