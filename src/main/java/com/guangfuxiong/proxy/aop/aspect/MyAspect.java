package com.guangfuxiong.proxy.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Pointcut("execution(* com.guangfuxiong.proxy.aop.service..*.addUser())")
    public void pointCut(){

    }
    @Before("pointCut()")
    public void before(){
        System.out.println("我是测试的前置通知");
    }
    @Around(value = "pointCut()")
    public Object arround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知开始-注解");
        Object result = proceedingJoinPoint.proceed();
        return result;
    }
    @AfterThrowing(value = "pointCut()",throwing = "throwable")
    public void afterThrow(Throwable throwable){
        System.out.println("异常信息为:"+throwable.getMessage());
        System.out.println("异常通知");
    }
    @AfterReturning("pointCut()")
    public void afterReturn(){
        System.out.println("后置通知");
    }
}
