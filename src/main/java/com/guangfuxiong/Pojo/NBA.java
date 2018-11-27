package com.guangfuxiong.Pojo;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy//实现懒加载
//@Scope(value = "")//实现单例多例配置
public class NBA implements BeanNameAware{
    public NBA() {
        System.out.println("创建NBA实例");
    }
    @PostConstruct//实现初始化方法配置
    public void init(){
        System.out.println("注解实现初始化方法");
    }
    @PreDestroy//实现销毁方法配置
    public void destroy(){
        System.out.println("注解实现销毁方法");
    }
    public void exercise(){
        System.out.println("NBA练习");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("当前类的bean的ID值："+s);
    }
}
