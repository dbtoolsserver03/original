package com.suns.nio02;

import java.nio.ByteBuffer;

public class TestNIO5 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});

        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println("buffer.get() = " + (char) buffer.get());
        }
        //postion = 4 limit = 4

        System.out.println("-----------------------------------------");
        buffer.rewind();//position = 0

        while (buffer.hasRemaining()) {
            System.out.println("buffer.get() = " + (char) buffer.get());
        }

    }
}
