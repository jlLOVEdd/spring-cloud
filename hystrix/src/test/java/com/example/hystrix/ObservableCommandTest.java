package com.example.hystrix;

import com.example.hystrix.service.common.ObservableCommandHelloWorld;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rx.Observable;

import java.util.Iterator;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 16:30 2018/12/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObservableCommandTest {

    @Test
    public void testHelloWorld(){
        Observable<String> observable= new ObservableCommandHelloWorld("World").observe();

        Iterator<String> iterator = observable.toBlocking().getIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
