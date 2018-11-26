package com.guangfuxiong.factory;

import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;

public class SpringFactory implements FactoryBean{
    public SpringFactory() {
        System.out.println("spring工厂");
    }

    @Override
    public Object getObject() throws Exception {
        return Calendar.getInstance();
    }

    @Override
    public Class<?> getObjectType() {
        return Calendar.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
