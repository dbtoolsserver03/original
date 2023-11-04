package com.suns.reactor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(Worker.class);
    private Selector selector;
    private Thread thread;
    private String name;

    private volatile boolean isCreated;//false

    private ConcurrentLinkedQueue<Runnable> runnables = new ConcurrentLinkedQueue<>();
    //构造方法

    //为什么不好？
    //Select Thread
    public Worker(String name) throws IOException {
        this.name = name;
       /* thread = new Thread(this, name);
        thread.start();
        selector = Selector.open();*/
    }

    //线程的任务
    public void register(SocketChannel sc) throws IOException, InterruptedException {
        log.debug("worker register invoke....");
        if (!isCreated) {
            thread = new Thread(this, name);
            thread.start();
            selector = Selector.open();
            isCreated = true;
        }
        runnables.add(() -> {
            try {
                sc.register(selector, SelectionKey.OP_READ);//reigster  select方法之前运行 。。
            } catch (ClosedChannelException e) {
                throw new RuntimeException(e);
            }
        });
        selector.wakeup();//select
    }

    @Override
    public void run() {
        while (true) {
            log.debug("worker run method invoke....");
            try {
                selector.select();

                Runnable poll = runnables.poll();
                if (poll != null) {
                    poll.run();
                }

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey sckey = iterator.next();
                    iterator.remove();

                    if (sckey.isReadable()) {
                        SocketChannel sc = (SocketChannel) sckey.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(30);
                        sc.read(buffer);
                        buffer.flip();
                        String result = Charset.defaultCharset().decode(buffer).toString();
                        System.out.println("result = " + result);
                    }

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
