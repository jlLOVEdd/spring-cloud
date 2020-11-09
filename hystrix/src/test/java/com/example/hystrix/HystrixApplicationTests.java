package com.example.hystrix;

import com.example.hystrix.service.common.ObservableUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HystrixApplicationTests {

    @Autowired
    ObservableUserService observableUserService;

    @Test
    public void contextLoads() {
        Iterator<String> iterator = observableUserService.getUserById(30L).toBlocking().getIterator();
        while (iterator.hasNext()) {
            System.out.println("===============" + iterator.next());
        }
    }

    @Test
    public void testTOObservable() {
        Iterator<String> iterator = observableUserService.getUserByName("me").toBlocking().getIterator();
        while (iterator.hasNext()) {
            System.out.println("===============" + iterator.next());
        }
    }

}
