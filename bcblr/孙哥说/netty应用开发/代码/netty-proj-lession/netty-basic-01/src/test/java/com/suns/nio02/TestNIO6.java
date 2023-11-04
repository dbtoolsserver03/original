package com.suns.nio02;

import java.nio.ByteBuffer;

public class TestNIO6 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});

        buffer.flip();
        System.out.println("buffer.get() = " + (char) buffer.get());//a
        System.out.println("buffer.get() = " + (char) buffer.get());//b
        buffer.mark();
        System.out.println("buffer.get() = " + (char) buffer.get());//c
        System.out.println("buffer.get() = " + (char) buffer.get());//d
        buffer.reset();
        System.out.println("buffer.get() = " + (char) buffer.get());//c
        System.out.println("buffer.get() = " + (char) buffer.get());//d


    }
}
