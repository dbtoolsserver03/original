package com.suns.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MyServer1 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //设置ServerSocketChannel 非阻塞
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8000));

        List<SocketChannel> channelList = new ArrayList<>();

        ByteBuffer buffer = ByteBuffer.allocate(20);
        while (true) {

            SocketChannel socketChannel = serverSocketChannel.accept();//阻塞 已经解决了 不阻塞了

            if (socketChannel != null) {
                socketChannel.configureBlocking(false);
                channelList.add(socketChannel);
            }

            //5. client与服务端 通信过程 NIO代码
            for (SocketChannel channel : channelList) {
                int read = channel.read(buffer);//阻塞 对应的IO通信的阻塞
                if (read > 0) {
                    System.out.println("开始实际的数据通信....");
                    buffer.flip();
                    CharBuffer decode = Charset.forName("UTF-8").decode(buffer);
                    System.out.println("decode.toString() = " + decode.toString());
                    buffer.clear();
                    System.out.println("通信已经结束....");
                }


            }

        }

    }
}
