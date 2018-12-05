package com.guangfuxiong.proxy.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectA {
    @Pointcut(value="execution(* com.guangfuxiong.proxy.aop.service..*.addUser())")
    public void pointCut(){

    }


    @Before("pointCut()")
    public void before(){
        System.out.println("我是测试的前置通知");
    }
}
