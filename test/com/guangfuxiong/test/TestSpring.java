package com.guangfuxiong.test;

import com.guangfuxiong.Pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        User user = (User)ac.getBean("user");
        user.hello();
    }
}
