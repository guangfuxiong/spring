package com.guangfuxiong.proxy.aop.aspect;

import com.guangfuxiong.proxy.aop.anno.Transaction;
import com.guangfuxiong.proxy.aop.tx.TransactionManage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionAspect {
    @Autowired
    TransactionManage tx;
    @Around(value = "execution(* com.guangfuxiong.proxy.aop.service..*.*(..))&&@annotation(transaction)&&target(t)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint,Transaction transaction,Object t) throws Throwable {
        Object result=null;
        System.out.println("环绕通知2");
        try {
            tx.begin();
            result = proceedingJoinPoint.proceed();
            tx.commit();
            System.out.println("环绕通知3");
            System.out.println("目标对象为:"+t.getClass());
        }catch (Exception e){
            tx.rollback();
        }
        return  result;
    }
}
