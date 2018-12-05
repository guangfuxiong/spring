package com.guangfuxiong.proxy.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class throwAspect {
    @AfterThrowing(value = "execution(* com.guangfuxiong.proxy.aop.service..*.addProduct())",throwing = "throwable")
    public void afterThrow(JoinPoint joinPoint, Throwable throwable){
        //获取目标对象类型
        Class targetClass = joinPoint.getTarget().getClass();
        //获取目标对象方法
        String methodName = joinPoint.getSignature().getName();
        //获取异常类型
        Class throwClass = throwable.getClass();
        //获取异常消息
        String throwMsg = throwable.getMessage();
        System.out.println("目标对象的类型:"+targetClass);
        System.out.println("目标方法:"+methodName);
        System.out.println("异常的类型:"+throwClass);
        System.out.println("异常信息:"+throwMsg);
    }
}
