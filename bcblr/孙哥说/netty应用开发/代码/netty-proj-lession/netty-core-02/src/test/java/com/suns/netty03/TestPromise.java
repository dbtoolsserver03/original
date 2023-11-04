package com.suns.netty03;

import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoop;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TestPromise {

    private static final Logger log = LoggerFactory.getLogger(TestPromise.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        EventLoop eventLoop  = new DefaultEventLoop().next();
        DefaultPromise<Integer> promise = new DefaultPromise<>(eventLoop);

        new Thread(()->{
            log.debug("异步处理....");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            promise.setSuccess(10);
        }).start();

        /*log.debug("等待异步处理的结果");
        log.debug("结果是 {}",promise.get());
        log.debug("----------------------");*/

        promise.addListener(new GenericFutureListener<Future<? super Integer>>() {
            @Override
            public void operationComplete(Future<? super Integer> future) throws Exception {
                log.debug("等待异步处理的结果");
                log.debug("结果是 {}",promise.get());
            }
        });

        log.debug("---------------------------------");
    }
}
