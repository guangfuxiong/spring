package com.guangfuxiong.proxy.proxy.proxy;

import com.guangfuxiong.proxy.proxy.service.UserService;
import com.guangfuxiong.proxy.proxy.tx.TransactionManage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    //创建代理对象，需要传入目标对象，事物对象
    public static Object getDynamicProxy(final UserService target, final TransactionManage tx){
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            //代理调用方法时才会执行invoke方法
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result=null;
                try {
                    tx.begin();
                    result = method.invoke(target,args);
                    tx.commit();
                }catch (Exception e){
                    e.printStackTrace();
                    tx.rollback();
                }
                return result;
            }
        });
        return proxy;
    }
}
