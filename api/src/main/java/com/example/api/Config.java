package com.example.api;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 10:39 2019/7/30
 */
@Configuration
public class Config {

    @Bean
    public RouteLocator myRoute(RouteLocatorBuilder builder){
        return builder.routes().build();
    }

}
