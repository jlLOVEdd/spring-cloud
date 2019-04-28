package com.example.ribbon.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.concurrent.ExecutionException;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 14:31 2019/4/28
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate RestTemplate;

    @RequestMapping("/consumer")
    public String helloConsumer() throws ExecutionException, InterruptedException {
        //这里是根据配置文件的那个providers属性取的
       return RestTemplate.getForObject("http://HELLO-SERVICE/hello",String.class);
    }
}