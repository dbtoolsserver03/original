package com.suns.nio02;

import java.nio.ByteBuffer;

public class TestNIO7 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});

        buffer.flip();
        System.out.println("buffer.get() = " + (char)buffer.get());//a position=1
        System.out.println("buffer.get(0) = " + (char)buffer.get(0));//a
        System.out.println(buffer.position());//1

    }
}
