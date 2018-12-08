package com.guangfuxiong.proxy.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RunTimeAspect {
    @Around(value = "execution(* com.guangfuxiong.proxy.aop.service..*.*(..))")
    public Object arround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知1");
        Long beginTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        System.out.println("执行业务方法耗时："+(endTime-beginTime)+"毫秒");
        return result;
    }
}
