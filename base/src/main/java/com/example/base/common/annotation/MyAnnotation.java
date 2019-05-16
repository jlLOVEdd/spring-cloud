package com.example.base.common.annotation;

import java.lang.annotation.*;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 10:18 2019/5/8
 */
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

    String name() default "";

    String value();

    String[] emails();
}
