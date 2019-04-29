package com.example.base.model;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 14:28 2019/4/29
 */
public class User {
    private String name;
    private Integer age;


    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

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
}
