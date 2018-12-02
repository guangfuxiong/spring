package com.guangfuxiong.proxy.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
//表示事务切面
public class TxAspect {
    //前置通知
    public void before(JoinPoint joinPoint){
        System.out.println("我是一个通知方法");

        //获取目标对象类型
        Class targetClass = joinPoint.getTarget().getClass();
        //获取目标对象方法名
        String methodName = joinPoint.getSignature().getName();
        //目标对象
        System.out.println("目标对象："+targetClass);
        //目标方法
        System.out.println("目标方法："+methodName);
    }
    //动态代理中。。。  method.invoke(target,args);  控制目标方法执行
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知开始");
        Object result = proceedingJoinPoint.proceed();//让目标方法执行
        System.out.println("环绕通知结束");
        return null;
    }
    //异常通知
    public void afterThrow(JoinPoint joinPoint,Throwable throwable){
        System.out.println("我是一个异常通知");
        Class throwClass = throwable.getClass();
        String msg = throwable.getMessage();
        System.out.println("异常对象类型为："+throwClass);
        System.out.println("异常信息为："+msg);
    }
    //后置通知
    public void after(JoinPoint joinPoint){
        System.out.println("后置通知：完毕！");
        System.out.println("目标对象："+joinPoint.getTarget().getClass());
    }
}
