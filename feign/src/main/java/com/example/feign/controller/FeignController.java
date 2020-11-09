package com.example.feign.controller;

import com.example.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 14:39 2019/4/29
 */
@RestController
public class FeignController {

    @Autowired
    FeignService feignService;


    @RequestMapping(name = "/feignHello")
    public String hello(){
      return  feignService.hello();
    }


}
