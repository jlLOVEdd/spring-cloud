package com.example.ribbon.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000"),
            @HystrixProperty(name = "execution.timeout.enabled",value = "true"),

    },fallbackMethod = "fallBackForTimeOut")
    public String helloConsumer() throws ExecutionException, InterruptedException {
        //这里是根据配置文件的那个providers属性取的
       return RestTemplate.getForObject("http://hello-service/hello",String.class);
    }

    public String fallBackForTimeOut(){
        return "time out fall back";
    }




    @RequestMapping("/pool/consumer")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000"),
            @HystrixProperty(name = "execution.timeout.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "3"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "30"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "4000")

    },fallbackMethod = "fallBackForTimeOut",
            threadPoolKey = "hello-pool",
            threadPoolProperties = {
              @HystrixProperty(name = "coreSize",value = "5"),
              @HystrixProperty(name = "maxQueueSize",value = "10")
            }

    )
    public String helloPoolConsumer()  {
        //这里是根据配置文件的那个providers属性取的
        return RestTemplate.getForObject("http://hello-service/hello",String.class);
    }
}
