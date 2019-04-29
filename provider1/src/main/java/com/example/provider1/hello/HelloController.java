package com.example.provider1.hello;

import com.example.base.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 15:16 2019/4/28
 */
@RestController
public class HelloController {
    @RequestMapping(name = "hello")
    public String hello() {

        return "1111";
    }

    //新增的方法
    @RequestMapping(value = "/hellol", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }

}
