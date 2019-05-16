package com.example.base;

import com.example.base.model.People;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 16:58 2019/5/7
 */
public class MainTest {

    public static void main(String[] args) {
        People<String> people = new People();
        people.setType("1111");
    }

    public static <T> T getObject(Class<T> clz){

        return getboy(clz).getType();
    }

    public static  <T> People<T> getboy(Class<T> tClass){

        return new People();
    }
}
