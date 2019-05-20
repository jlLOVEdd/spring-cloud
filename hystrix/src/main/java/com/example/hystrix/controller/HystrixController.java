package com.example.hystrix.controller;

import com.example.hystrix.service.common.ObservableCommand;
import com.example.hystrix.service.HystrixService;
import com.example.hystrix.service.common.ObservableUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;
import rx.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 10:34 2019/4/29
 */
@RestController
public class HystrixController {

    @Autowired
    HystrixService hystriService;

    ObservableCommand observableCommand = new ObservableCommand();

    @Autowired
    ObservableUserService observableUserService;

    @RequestMapping("/hystrixConsumer")
    public String hystrixConsumer(){
        return hystriService.hystrixConsumer();
    }

    @RequestMapping("/Observable")
    public String Observable(){
        List<String> result = new ArrayList<>();
        Observable<String> observable = observableUserService.getUserById(30L);
        observable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                result.forEach(v->{
                    System.out.println(v);
                });
                System.out.println("最终请求结束");

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                System.out.println("ssss");
            }

            @Override
            public void onNext(String s) {
               result.add(s);
            }
        });
        return result.get(0);
    }
}
