package com.suns.netty05;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;

public class TestByteBuf {
    public static void main(String[] args) {
        //如何获得ByteBuf
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(10);

        //默认的ByteBuf 默认256  最大的内存空间Integer最大值 21亿
        //ByteBuf buffer1 = ByteBufAllocator.DEFAULT.buffer();

        buffer.writeByte('a');
        buffer.writeInt(10);
        buffer.writeInt(11);
        buffer.writeInt(12); //13个字节


        System.out.println(buffer);
        System.out.println(ByteBufUtil.prettyHexDump(buffer));


    }
}
