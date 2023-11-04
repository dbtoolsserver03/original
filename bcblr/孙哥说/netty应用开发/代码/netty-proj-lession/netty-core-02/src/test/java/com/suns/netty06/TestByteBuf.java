package com.suns.netty06;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.junit.Test;

public class TestByteBuf {
    public static void main(String[] args) {
        //如何获得ByteBuf 1. 支持自动扩容 2. 制定byteBuf初始化大小 3.256 3. 最大值 Integer.max,在构造方法中指定最大值
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(10);
        System.out.println("buffer = " + buffer);


        //默认的ByteBuf 默认256  最大的内存空间Integer最大值 21亿
        //ByteBuf buffer1 = ByteBufAllocator.DEFAULT.buffer();

       /* buffer.writeByte('a');
        buffer.writeInt(10);
        buffer.writeInt(11);
        buffer.writeInt(12); //13个字节
*/
   /*     for (int i = 0; i < 513; i++) {
            buffer.writeByte(1);
        }

        System.out.println(buffer);
        System.out.println(ByteBufUtil.prettyHexDump(buffer));*/

    }


    @Test
    public void test1() {
        //为了测试 堆内存 和 直接内存创建
        //创建的是直接内存
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(10);
        System.out.println("buffer = " + buffer);

        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.directBuffer();
        System.out.println("byteBuf = " + byteBuf);

        ByteBuf byteBuf1 = ByteBufAllocator.DEFAULT.heapBuffer();
        System.out.println("byteBuf1 = " + byteBuf1);
    }
}
