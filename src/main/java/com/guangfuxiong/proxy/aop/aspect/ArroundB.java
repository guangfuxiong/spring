package com.guangfuxiong.proxy.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class ArroundB {
    public void before(){
        System.out.println("B的前置通知");
    }
    public Object arround(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("B环绕通知开始");
        Object result = pj.proceed();
        System.out.println("B环绕通知结束");
        return  result;
    }
    public void afterReturn(){
        System.out.println("B的后置通知");
    }
}
