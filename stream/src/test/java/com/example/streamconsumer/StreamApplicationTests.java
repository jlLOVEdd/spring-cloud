package com.example.streamconsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=StreamApplication.class)
public class StreamApplicationTests {

   @Autowired
    private StreamClient streamClient;

   @Test
    public void send() {
        streamClient.output().send(MessageBuilder.withPayload("Hello World...").build());
    }
}