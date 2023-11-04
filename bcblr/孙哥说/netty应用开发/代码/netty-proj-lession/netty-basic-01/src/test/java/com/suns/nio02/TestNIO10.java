package com.suns.nio02;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class TestNIO10 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(50);
        buffer.put("Hi sunshuai\nl love y".getBytes());
        doLineSplit(buffer);
        buffer.put("ou\nDo you like me?\n".getBytes());
        doLineSplit(buffer);
    }

    // ByteBuffer接受的数据 \n
    private static void doLineSplit(ByteBuffer buffer) {
        buffer.flip();
        for (int i = 0; i < buffer.limit(); i++) {
            if (buffer.get(i) == '\n') {
                int length = i + 1 - buffer.position();
                ByteBuffer target = ByteBuffer.allocate(length);
                for (int j = 0; j < length; j++) {
                    target.put(buffer.get());
                }

                //截取工作完成
                target.flip();
                System.out.println("StandardCharsets.UTF_8.decode(target).toString() = " + StandardCharsets.UTF_8.decode(target).toString());
            }
        }
        buffer.compact();
    }
}
