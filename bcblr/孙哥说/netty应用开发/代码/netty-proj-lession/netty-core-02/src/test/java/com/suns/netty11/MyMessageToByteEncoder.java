package com.suns.netty11;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

public class MyMessageToByteEncoder extends MessageToByteEncoder<Message>{

    private static final Logger log = LoggerFactory.getLogger(MyMessageToByteEncoder.class);

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
        log.debug("encode method invoke ");
        //1. 幻术 4个字节 suns
        out.writeBytes(new byte[]{'s', 'u', 'n', 's'});
        //2. 协议版本 1个字节
        out.writeByte(1);
        //3. 序列化方式 1个字节 1.json 2 protobuf 3 hession
        out.writeByte(1);
        //4. 功能指令 1个字节  1 登录 2 注册
        out.writeByte(1);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonContent = objectMapper.writeValueAsString(msg);

        //5. 正文长度 4个字节
        out.writeInt(jsonContent.length());

        //6. 正文
        out.writeCharSequence(jsonContent, Charset.defaultCharset());

    }
}
