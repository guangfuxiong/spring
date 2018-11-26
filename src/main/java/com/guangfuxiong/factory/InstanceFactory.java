package com.guangfuxiong.factory;

import java.util.Calendar;

public class InstanceFactory {
    //实例工厂
    public InstanceFactory() {
        System.out.println("实例工厂");
    }
    public Calendar getCalendar(){
        return Calendar.getInstance();
    }
}
