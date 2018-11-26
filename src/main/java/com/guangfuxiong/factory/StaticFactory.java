package com.guangfuxiong.factory;

import java.util.Calendar;

public class StaticFactory {
    public StaticFactory() {
        System.out.println("静态工厂");
    }
    public static Calendar getCalendar(){
        return Calendar.getInstance();
    }
}
