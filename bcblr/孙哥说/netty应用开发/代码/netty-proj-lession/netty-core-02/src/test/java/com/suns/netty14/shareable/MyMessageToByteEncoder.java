package com.suns.netty14.shareable;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.List;

@ChannelHandler.Sharable
public class MyMessageToByteEncoder extends MessageToMessageEncoder<Message> {

    private static final Logger log = LoggerFactory.getLogger(MyMessageToByteEncoder.class);

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> out) throws Exception {
        log.debug("encode method invoke ");

        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        //1. 幻术 4个字节 suns
        byteBuf.writeBytes(new byte[]{'s', 'u', 'n', 's'});
        //2. 协议版本 1个字节
        byteBuf.writeByte(1);
        //3. 序列化方式 1个字节 1.json 2 protobuf 3 hession
        byteBuf.writeByte(1);
        //4. 功能指令 1个字节  1 登录 2 注册
        byteBuf.writeByte(1);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonContent = objectMapper.writeValueAsString(msg);

        //5. 正文长度 4个字节
        byteBuf.writeInt(jsonContent.length());

        //6. 正文
        byteBuf.writeCharSequence(jsonContent, Charset.defaultCharset());

        out.add(byteBuf);
    }
}
