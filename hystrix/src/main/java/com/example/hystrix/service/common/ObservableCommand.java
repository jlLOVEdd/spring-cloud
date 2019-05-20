package com.example.hystrix.service.common;

import com.netflix.hystrix.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.observables.SyncOnSubscribe;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 17:06 2019/5/16
 */
public class ObservableCommand extends HystrixObservableCommand<String> {

    @Autowired
    RestTemplate restTemplate;

    public ObservableCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GroupName"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("commandKey"))
        );
    }

    @Override
    public  Observable<String> construct() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    if (!subscriber.isUnsubscribed()){
                        System.out.println("方法执行....");
                        String result = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
                        //这个方法监听方法，是传递结果的，请求多次的结果通过它返回去汇总起来。
                        subscriber.onNext(result);
                        String result1 = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
                        //这个方法是监听方法，传递结果的
                        subscriber.onNext(result1);
                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

    //服务降级Fallback
    @Override
    protected Observable<String> resumeWithFallback() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext("error");
                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
