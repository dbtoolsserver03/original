package com.suns.netty10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MyByteToLongDecoder1 extends ReplayingDecoder {

    private static final Logger log = LoggerFactory.getLogger(MyByteToLongDecoder1.class);

    @Override
    //如果实现了ReplayingDecoder
    //所有安全校验的功能，都不用再decode中写了
    //为什么？
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        log.debug("decode method invoke ...");
        out.add(in.readLong());

    }
}
