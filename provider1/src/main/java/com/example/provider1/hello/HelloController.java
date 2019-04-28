package com.example.provider1.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 15:16 2019/4/28
 */
@RestController
public class HelloController {
    @RequestMapping(name = "hello")
    public String hello(){

        return "1111";
    }
}
