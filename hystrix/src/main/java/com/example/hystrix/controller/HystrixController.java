package com.example.hystrix.controller;

import com.example.hystrix.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 10:34 2019/4/29
 */
@RestController
public class HystrixController {

    @Autowired
    HystrixService hystriService;

    @RequestMapping("/hystrixConsumer")
    public String hystrixConsumer(){
        return hystriService.hystrixConsumer();
    }
}
