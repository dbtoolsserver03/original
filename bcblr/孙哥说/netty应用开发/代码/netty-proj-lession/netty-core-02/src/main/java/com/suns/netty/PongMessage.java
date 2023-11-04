package com.suns.netty;

import com.suns.netty.message.AbstractResponseMessage;
import com.suns.netty.message.MessageType;

public class PongMessage extends AbstractResponseMessage {
    private String source;
    public PongMessage(String source) {
        this.source = source;
    }

    public PongMessage() {
    }

    @Override
    public int getMessageType() {
        return MessageType.PONG_MESSAGE;
    }
}
