package com.example.hystrix.service.common;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import org.springframework.stereotype.Service;
import rx.Observable;
import rx.Subscriber;

@Service
public class ObservableUserService {
    /**
     *  EAGER参数表示使用observe()方式执行
     */
    @HystrixCommand(observableExecutionMode = ObservableExecutionMode.EAGER, fallbackMethod = "observFailed") //使用observe()执行方式
    public Observable<String> getUserById(final Long id) {
        return Observable.create(subscriber -> {
            try {
                if(!subscriber.isUnsubscribed()) {

                    subscriber.onNext("张三的ID:");

                    subscriber.onNext(String.valueOf(id));
                    int i = 1 / 0; //抛异常，模拟服务降级
                    subscriber.onCompleted();
                }
            } catch (Exception e) {
                e.printStackTrace();
                subscriber.onError(e);
            }
        });
    }

    private String observFailed(Long id) {
        System.out.println(id);
        return "observFailed---->" + id;
    }

    /**
     * LAZY参数表示使用toObservable()方式执行
     */
    @HystrixCommand(observableExecutionMode = ObservableExecutionMode.LAZY, fallbackMethod = "toObserbableError") //表示使用toObservable()执行方式
    public Observable<String> getUserByName(final String name) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    if(!subscriber.isUnsubscribed()) {
                        subscriber.onNext("找到");
                        subscriber.onNext(name);
                        int i = 1/0; ////抛异常，模拟服务降级
                        subscriber.onNext("了");
                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    private String toObserbableError(String name) {
        System.out.println(name);
        return "toObserbableError--->" + name;
    }

}