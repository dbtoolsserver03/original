package com.suns.netty03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class TestJDKFuture {

    private static final Logger log = LoggerFactory.getLogger(TestJDKFuture.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
           JDK什么情况下考虑使用Future
           异步化的工作 Future
                        启动一个新的线程进行处理。最后把处理结果返回给主线程（调用者线程）

           JDK Future处理过程中 异步操作的处理 只能通过阻塞的方式完成。
         */
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("异步的工作处理...");
                TimeUnit.SECONDS.sleep(10);
                return 10;
            }
        });

        log.debug("可以处理结果了...");
        log.debug("处理结果 {}",future.get());//阻塞的操作..
        log.debug("------------------------------------");

    }
}
