package com.example.ribbon01.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {
    /**
     * 显示声明负载策略 默认的策略就会失效
     *
     * @return
     */
    /*@Bean
    public RandomRule createRule(){
        return new RandomRule();
    }*/
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
