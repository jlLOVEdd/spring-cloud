package com.example.provider2.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 15:18 2019/4/28
 */
@RestController
public class HelloController {

    @RequestMapping(name = "hello")
    public String hello() {

        return "2222222";
    }
}
