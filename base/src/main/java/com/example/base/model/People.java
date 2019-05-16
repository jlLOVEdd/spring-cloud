package com.example.base.model;

import com.example.base.common.annotation.MyAnnotation;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 16:57 2019/5/7
 */
public class People<T> {

    @MyAnnotation(value = "sss",emails = {"www","sdfs"})
    private T type;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }
}
