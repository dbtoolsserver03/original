package com.suns.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class MyClient {

    public static void main(String[] args) throws IOException {
        //连接服务端  端口号？
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(8000));
        //        socketChannel.write(Charset.defaultCharset().encode("hello\nsuns\n"));
        socketChannel.write(Charset.defaultCharset().encode("hellosuns\n"));
        System.out.println("------------------------------");
    }
}
