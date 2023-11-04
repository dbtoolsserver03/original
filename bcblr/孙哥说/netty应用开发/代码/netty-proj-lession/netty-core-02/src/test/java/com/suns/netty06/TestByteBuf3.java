package com.suns.netty06;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;

public class TestByteBuf3 {
    public static void main(String[] args) {
        //0copy
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer(10);
        buf.writeBytes(new byte[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'});


        System.out.println(buf);
        System.out.println(ByteBufUtil.prettyHexDump(buf));

        ByteBuf s1 = buf.slice(0, 6);
        s1.retain();
        System.out.println(s1);
        ByteBuf s2 = buf.slice(6, 4);
        s2.retain();
        System.out.println(s2);


        buf.release();
        System.out.println(ByteBufUtil.prettyHexDump(s1));
        System.out.println(ByteBufUtil.prettyHexDump(s2));





    }

}
