package com.guangfuxiong.Pojo;

public class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User() {
        System.out.println("User实例");
    }

    public void init_1(){
        System.out.println("初始化方法");
    }
    public void hello(){
        System.out.println("Hello World!");
    }
    public void des(){
        System.out.println("销毁方法");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
