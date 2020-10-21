package com.example.eurekaserver34;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer34Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer34Application.class, args);
    }

}
