package com.suns.reactor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/*
    SLF4 门面
    实现  log42
         logback
 */

public class ReactorBossServer {

    private static final Logger log = LoggerFactory.getLogger(ReactorBossServer.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        log.debug("boss thread start ....");

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ssc.bind(new InetSocketAddress(8000));

        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        //模拟多线程的环境，在实际开发中，还是要使用线程池
        /*
        Worker worker = new Worker("worker1");
        */

        Worker[] workers = new Worker[2];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker("worker - " + i);//worker-0 worker-1
        }

        AtomicInteger index = new AtomicInteger();


        while (true) {
            selector.select();

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey sscSelectionKey = iterator.next();
                iterator.remove();

                if (sscSelectionKey.isAcceptable()) {
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);

                    //sc.register(selector, SelectionKey.OP_READ);
                    log.debug("boss invoke worker register ...");
                    //worker-0 worker-1 worker-0 worker-1
                    //hash取摸    x%2= 0  1 [0,1,0,1]
                    workers[index.getAndIncrement()% workers.length].register(sc);
                    log.debug("boss invoked worker register");
                }
            }
        }


    }
}
