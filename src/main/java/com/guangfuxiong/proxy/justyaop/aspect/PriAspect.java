package com.guangfuxiong.proxy.justyaop.aspect;

import com.guangfuxiong.proxy.justyaop.anno.PrivilegeInfo;
import com.guangfuxiong.proxy.justyaop.util.PriList;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

@Component
@Aspect
public class PriAspect {
    /**
     * 权限控制的实现思路
     * 1.准备用户的权限列表  List<String>
     * 2.获取用户所拥有的权限列表
     * 	 2.1用户通过静态方法 将参数传入工具类中
     *   2.2切面中通过静态方法获取权限列表
     * 3.获取方法上的注解
     *
     * 	 3.1 先获取Method对象     通过Class.getMethod(方法名称,class参数列表);
     *   3.2在通过method获取注解对象
     *   3.3通过注解对象 获取name属性值
     *   3.4根据属性值判断权限是否满足
     * @throws Throwable
     */
    @Around(value = "execution(* com.guangfuxiong.proxy.justyaop.service..*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取用户权限列表


        List<String> priList = PriList.getPriList();
        //1.获取目标对象的Class类型
        Class targetClass = joinPoint.getTarget().getClass();

        //2.获取方法名称
        String methodName = joinPoint.getSignature().getName();

        //3.获取参数列表
        Object[] args = joinPoint.getArgs();   //Object类型的数组

        Class[] classArgs = new Class[args.length];

        for(int i=0;i<args.length;i++){
            classArgs[i] = args[i].getClass();
        }
        //获取目标方法对象
        Method method = targetClass.getMethod(methodName,classArgs);
        //判断是否含有注解权限
        if(method.isAnnotationPresent(PrivilegeInfo.class)){
            //表示含有注解

            //获取注解对象
            PrivilegeInfo info = method.getAnnotation(PrivilegeInfo.class);
            //获取权限值
            String pName = info.name();
            //判断用户列表是否含有该权限
            if(priList.contains(pName)){
                //含有权限
                System.out.println("恭喜你有该权限");
                Object result = joinPoint.proceed();
                return result;
            }else {
                System.out.println("权限不足，无法访问");
                return null;
            }
        }else {
            //这里表示不需要权限就可以直接访问
            Object result = joinPoint.proceed();
            return result;
        }
    }
}
