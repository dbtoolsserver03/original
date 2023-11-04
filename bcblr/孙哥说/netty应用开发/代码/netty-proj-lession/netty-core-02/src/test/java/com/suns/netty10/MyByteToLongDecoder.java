package com.suns.netty10;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MyByteToLongDecoder extends ByteToMessageDecoder {

    private static final Logger log = LoggerFactory.getLogger(MyByteToLongDecoder.class);

    @Override
    //获得了ctx等于拿到了这个channel相关的pipeline中的所有信息
    //1. channel
    //2. ByteBuf
    //ByteBuf in client提交上来的数据
    // decode方法处理的过程中，如果bytebuf没有处理完，那么他会重复调用decode方法
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        log.debug("decode method invoke ...");//ssss
        if (in.readableBytes() >= 8) {
            in.markReaderIndex();
            try {
                long reciveLong = in.readLong();
                out.add(reciveLong);
            } catch (Exception e) {
                in.resetReaderIndex();
                throw new RuntimeException(e);
            }
        }
        System.out.println(ByteBufUtil.prettyHexDump(in));
    }
}
