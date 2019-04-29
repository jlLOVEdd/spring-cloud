package com.example.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 10:35 2019/4/29
 */
@Service
public class HystrixService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallBack")
    public String hystriConsumer(){
        return restTemplate.getForObject("http://HELLO-SERVICE/hello",String.class);
    }

    public String fallBack(){
        return "error";
    }
}
