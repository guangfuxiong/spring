package com.guangfuxiong.proxy.proxy.proxy;

import com.guangfuxiong.proxy.proxy.service.UserService;
import com.guangfuxiong.proxy.proxy.tx.TransactionManage;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DynamicProxy_cglib {
    //创建代理，需要传入真实对象和事物对象
    public static Object getDynamciProxy(final UserService target, final TransactionManage tx){
        //1、创建增强器
        Enhancer enhancer = new Enhancer();
        //2、设置接口
        //enhancer.setInterfaces(target.getClass().getInterfaces());
        //3、设置父类，cglib生成的对象是目标对象的子类
        enhancer.setSuperclass(target.getClass());
        //4、设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result=null;
                try {
                    tx.begin();
                    result = method.invoke(target,objects);
                    tx.commit();
                }catch (Exception e){
                    tx.rollback();
                    e.printStackTrace();
                }
                return result;
            }
        });
        return enhancer.create();
    }
}
