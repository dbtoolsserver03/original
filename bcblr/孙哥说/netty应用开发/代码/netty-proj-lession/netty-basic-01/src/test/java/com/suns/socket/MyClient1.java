package com.suns.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
// client接受服务端 传递过来的数据
public class MyClient1 {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(8000));

        int read = 0;
        while (true) {
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
            read += socketChannel.read(buffer);
            System.out.println("read = " + read);
            buffer.clear();
        }


    }
}
