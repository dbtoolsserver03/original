package com.suns.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class MyServer3 {
    private static void doLineSplit(ByteBuffer buffer) {
        buffer.flip();
        for (int i = 0; i < buffer.limit(); i++) {
            if (buffer.get(i) == '\n') {//hellosu
                int length = i + 1 - buffer.position();
                ByteBuffer target = ByteBuffer.allocate(length);
                for (int j = 0; j < length; j++) {
                    target.put(buffer.get());
                }

                //截取工作完成
                target.flip();
                System.out.println("StandardCharsets.UTF_8.decode(target).toString() = " + StandardCharsets.UTF_8.decode(target).toString());
            }
        }
        buffer.compact();
    }

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
                    ByteBuffer buffer = ByteBuffer.allocate(7);
                    SelectionKey sckey = sc.register(selector, 0, buffer);
                    sckey.interestOps(SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    try {
                        SocketChannel sc = (SocketChannel) key.channel();    //ByteBuffer ---> s...
                        //ByteBuffer buffer = ByteBuffer.allocate(7);//创建一个ByteBuffer 新的ByteBuffer..
                        //从channel中获得 绑定的那个bytebuffer
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        int read = sc.read(buffer);
                        if (read == -1) {
                            key.cancel();
                        } else {
                            /*
                            buffer.flip();
                            System.out.println("Charset.defaultCharset().decode(buffer).toString() = " + Charset.defaultCharset().decode(buffer).toString());
                            */
                            doLineSplit(buffer);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        key.cancel();
                    }
                }
            }

        }
          /*  如何保证 前后2次操作的ByteBuffer是同一个。
              ByteBuffer和谁有关的呢？---> channel 相关
              ByteBuffer和Channel绑定就行了

              怎么绑定 ？  channel.register(selector,0,attament)--> attarment 附件

          *
          * */

    }
}
