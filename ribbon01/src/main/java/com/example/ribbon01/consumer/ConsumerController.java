package com.example.ribbon01.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
       return RestTemplate.getForObject("http://hello-service/hello",String.class);
    }
}
