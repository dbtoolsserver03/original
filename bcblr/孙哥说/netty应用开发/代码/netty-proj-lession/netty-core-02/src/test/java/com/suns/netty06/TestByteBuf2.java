package com.suns.netty06;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;

public class TestByteBuf2 {
    public static void main(String[] args) {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer(10);

        // ridx = 0 widx = 1
        byteBuf.writeByte(5);

        byteBuf.setByte(0, 10);

        System.out.println("byteBuf = " + byteBuf);
        System.out.println(ByteBufUtil.prettyHexDump(byteBuf));

        /*System.out.println("byteBuf = " + byteBuf);
        System.out.println(ByteBufUtil.prettyHexDump(byteBuf));

        byteBuf.markReaderIndex();
        byte b = byteBuf.readByte();
        System.out.println("b = " + b);
        System.out.println("byteBuf = " + byteBuf);
        System.out.println(ByteBufUtil.prettyHexDump(byteBuf));


        byteBuf.resetReaderIndex();
        byte b1 = byteBuf.readByte();
        System.out.println("reset b = " + b);
        System.out.println("byteBuf = " + byteBuf);
        System.out.println(ByteBufUtil.prettyHexDump(byteBuf));*/
    }
}
