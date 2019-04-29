package com.example.feign.service;

import com.example.base.model.User;
import com.example.fallBack.FeignFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 14:18 2019/4/29
 */
@FeignClient(value = "HELLO-SERVICE",fallback = FeignFallBack.class)
public interface FeignService {
    @RequestMapping(name = "hello")
    public String hello();

    //新增的方法
    @RequestMapping(value = "/hellol", method= RequestMethod.GET)
    public String hello(@RequestParam String name);

    @RequestMapping(value = "/hello2", method= RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age);

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello (@RequestBody User user);
}
