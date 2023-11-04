package com.suns.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;

public class MyServer2 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8000));
        serverSocketChannel.configureBlocking(false);//Selector 只有在非阻塞的情况下 才可以使用。

        //引入监管者
        Selector selector = Selector.open();//1. 工厂，2. 单例

        //监管者 管理谁？ selector.xxxx(ssc); //管理者 ssc  ---> Accept
        SelectionKey selectionKey = serverSocketChannel.register(selector, 0, null);
        // selector监控 SSC ACCEPT
        // selector
        //   keys --> HashSet
        //  register注册 ssc
        selectionKey.interestOps(SelectionKey.OP_ACCEPT);

        System.out.println("MyServler2.main");

        //监控
        while (true) {
            selector.select();//等待.只有监控到了 有实际的连接 或者 读写操作 ，才会处理。
            //对应的 有ACCEPT状态的SSC 和 READ WRITE状态的 SC 存起来
            // SelectionsKeys HashSet

            System.out.println("-------------------------");

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {//ServerSocketChannel ScoketChannel
                SelectionKey key = iterator.next();
                //用完之后 就要把他从SelectedKeys集合中删除掉。问题？ ServerScoketChannel---SelectedKeys删除 ，后续 SSC建立新的连接？
                iterator.remove();

                if (key.isAcceptable()) {
                    //serverSocketChannel.accept();
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel sc = channel.accept();
                    sc.configureBlocking(false);
                    //监控sc状态 ---> keys
                    SelectionKey sckey = sc.register(selector, 0, null);
                    sckey.interestOps(SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    try {
                        SocketChannel sc = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(5);
                        int read = sc.read(buffer);
                        if (read == -1) {
                            key.cancel();
                        } else {
                            buffer.flip();
                            System.out.println("Charset.defaultCharset().decode(buffer).toString() = " + Charset.defaultCharset().decode(buffer).toString());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        key.cancel();
                    }
                }
            }

        }


    }
}
