package com.example.hystrix.service.common;

import com.example.base.model.User;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.observables.SyncOnSubscribe;
import rx.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 11:13 2019/5/17
 */
public class ObservableRx extends HystrixObservableCommand<String> {


    protected ObservableRx(HystrixCommandGroupKey group) {
        super(group);
    }

    @Override
    protected Observable<String> construct() {
        return Observable.create(new SyncOnSubscribe<String, String>() {
            @Override
            protected String generateState() {
                return null;
            }

            @Override
            protected String next(String state, Observer<? super String> observer) {
                return null;
            }
        }).subscribeOn(Schedulers.io());
    }
}
