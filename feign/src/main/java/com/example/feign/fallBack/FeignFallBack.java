package com.example.feign.fallBack;

import com.example.base.model.User;
import com.example.feign.service.FeignService;
import org.springframework.stereotype.Component;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 14:41 2019/4/29
 */
@Component
public class FeignFallBack implements FeignService {

    @Override
    public String hello() {
        return "hello_error";
    }

    @Override
    public String hello(String name) {
        return "hello_name_error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("error", 11);
    }

    @Override
    public String hello(User user) {
        return "user_error";
    }
}
