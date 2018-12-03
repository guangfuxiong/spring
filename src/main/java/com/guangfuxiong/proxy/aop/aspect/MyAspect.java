package com.guangfuxiong.proxy.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Before( "execution(* com.guangfuxiong.proxy.aop.service..*.*(..))")
    public void before(){
        System.out.println("前置通知-注解");
    }
    @Around("execution(* com.guangfuxiong.proxy.aop.service..*(..))")
    public Object arround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知开始-注解");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("环绕通知结束-注解");
        return result;
    }
    @AfterReturning("execution(* com.guangfuxiong.proxy.aop.service..*.*(..))")
    public void afterReturn(){
        System.out.println("后置通知");
    }
}
