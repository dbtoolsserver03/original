package com.suns.netty03;

import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.EventLoop;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TestNettyFuture {

    private static final Logger log = LoggerFactory.getLogger(TestNettyFuture.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // EventLoopGroup 使用Netty Future---> EventLoopGroup -- NioEventLoopGroup--> selector 事件的监听
        // 异步工作的处理 ，启动一个新的线程 完成操作
        DefaultEventLoopGroup defaultEventLoopGroup = new DefaultEventLoopGroup(2);

        EventLoop eventLoop = defaultEventLoopGroup.next();

        //如何证明 10 主线程 获得结果. 但是不能证明 这个结果是正常的还是失败呢
        // 异步处理的2个问题
        //  runable接口 ---》 主线程（调用者线程）返回结果
        //  callable接口 ---》 返回值 也不能准确的表达 结果 成功 还是 失败了。
        Future<Integer> future = eventLoop.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                try {
                    log.debug("异步操作处理...");
                    TimeUnit.SECONDS.sleep(10);
                    return 10;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return -1;
                }

            }
        });

        //log.debug("可以接受异步处理");
        //同步阻塞 处理
        //log.debug("异步处理的结果...{} ",future.get());
        //log.debug("--------------------------------------------");

        future.addListener(new GenericFutureListener<Future<? super Integer>>() {
            @Override
            public void operationComplete(Future<? super Integer> future) throws Exception {
                  log.debug("异步处理的结果...{} ",future.get());
            }
        });

        log.debug("---------------------------------------");


    }
}
