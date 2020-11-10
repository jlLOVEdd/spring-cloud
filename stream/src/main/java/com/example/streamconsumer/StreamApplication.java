package com.example.streamconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(value = {StreamClient.class})
public class StreamApplication {


    public static void main(String[] args) {
        SpringApplication.run(StreamApplication.class, args);
    }


}
