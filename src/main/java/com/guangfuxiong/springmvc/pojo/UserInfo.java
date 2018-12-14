package com.guangfuxiong.springmvc.pojo;

public class UserInfo {
    private Integer age;

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "UserInfo [age=" + age + "]";
    }

}
