package com.suns.netty02;

import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestEventLoopGroup {

    private static final Logger log = LoggerFactory.getLogger(TestEventLoopGroup.class);

    public static void main(String[] args) {
        //创建多个EventLoop（线程）,并存起来
        //1 通过构造方法 可以指定创建EventLoop的个数（线程个数）
        //2 默认无参构造 内置创建EventLoop 无参构造，创建多少个EventLoop
        //  默认创建 教师机 32线程

        /*
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup(2);

        EventLoop el1 = eventLoopGroup.next();
        EventLoop el2 = eventLoopGroup.next();
        EventLoop el3 = eventLoopGroup.next();

        System.out.println("el1 = " + el1);
        System.out.println("el2 = " + el2);
        System.out.println("el3 = " + el3);
        */


        EventLoopGroup defaultEventLoopGroups = new DefaultEventLoopGroup();
        EventLoop defaultEventLoop = defaultEventLoopGroups.next();

        defaultEventLoop.submit(() -> {
            log.debug("hello");
        });
    }
}
