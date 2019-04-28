package com.example.eurereserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurereServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurereServerApplication.class, args);
    }

}
