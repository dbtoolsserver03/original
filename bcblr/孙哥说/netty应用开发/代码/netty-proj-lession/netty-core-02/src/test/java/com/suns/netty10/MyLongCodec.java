package com.suns.netty10;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;

import java.util.List;

public class MyLongCodec extends ByteToMessageCodec<String> {
    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, ByteBuf out) throws Exception {
        String[] messges = msg.split("-");
        for (String messge : messges) {
            long resultLong = Long.parseLong(messge);
            //每一个long类型的数据，在bytebuf中占用8个字节
            out.writeLong(resultLong);
        }
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List out) throws Exception {
        if (in.readableBytes() >= 8) {
            long reciveLong = in.readLong();
            out.add(reciveLong);
        }
        System.out.println(ByteBufUtil.prettyHexDump(in));
    }
}
