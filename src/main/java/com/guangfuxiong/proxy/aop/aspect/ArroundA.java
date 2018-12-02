package com.guangfuxiong.proxy.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class ArroundA {
    public void before(){
        System.out.println("A的前置通知");
    }
    public Object arround(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("环绕A开始");
        Object result = pj.proceed();
        System.out.println("环绕A结束");
        return result;
    }
    public void afterReturn(){
        System.out.println("A的后置通知");
    }
}
