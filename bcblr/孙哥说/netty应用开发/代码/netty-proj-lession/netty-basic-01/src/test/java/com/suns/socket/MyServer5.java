package com.suns.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;

/*
   这个代码 演示服务器 写操作
 */
public class MyServer5 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8000));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();//selector注册 集合 SocketChannel

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey sscKey = iterator.next();
                iterator.remove();

                if (sscKey.isAcceptable()) {
                    SocketChannel sc = serverSocketChannel.accept();
                    sc.configureBlocking(false);
                    SelectionKey sckey = sc.register(selector, SelectionKey.OP_READ);

                    //准备数据
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < 2000000; i++) {
                        sb.append("s");
                    }

                    //NIO  Buffer存储数据 channel写
                    ByteBuffer buffer = Charset.defaultCharset().encode(sb.toString());

                    int write = sc.write(buffer);
                    System.out.println("write = " + write);

                    if (buffer.hasRemaining()) {
                        //为当前的SoketChannel增加 Write的监听
                        //READ + Write
                        sckey.interestOps(sckey.interestOps() + SelectionKey.OP_WRITE);
                        //把剩余数据存储的buffer传递过去
                        sckey.attach(buffer);
                    }

                } else if (sscKey.isWritable()) {
                    //循环含义的
                    //channel
                    SocketChannel sc = (SocketChannel) sscKey.channel();
                    //buffer
                    ByteBuffer buffer = (ByteBuffer) sscKey.attachment();

                    //写操作
                    int write = sc.write(buffer);
                    System.out.println("write = " + write);


                    if (!buffer.hasRemaining()) {
                        sscKey.attach(null);
                        sscKey.interestOps(sscKey.interestOps() - SelectionKey.OP_WRITE);
                    }
                }


            }


        }


    }
}
