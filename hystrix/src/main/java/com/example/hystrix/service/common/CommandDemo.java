package com.example.hystrix.service.common;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;

/**
 * @Author: weidongdong
 * @Description:
 * @Date: Created in 15:42 2019/5/16
 */
public class CommandDemo extends HystrixCommand<String> {

    public CommandDemo() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GroupName"))
                    .andCommandKey(HystrixCommandKey.Factory.asKey("commandKey"))
                    .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("threadKey"))
        );
    }

    @Override
    protected String run() throws Exception {
        return null;
    }

    @Override
    protected String getFallback() {
        return super.getFallback();
    }

    @Override
    protected String getCacheKey() {
        return super.getCacheKey();
    }
}
