package com.suns.nio02;

import java.nio.ByteBuffer;

public class TestNIO8 {
    public static void main(String[] args) {
        /*ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put("孙帅".getBytes());//UTF-8 3 GBK 2

        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println("buffer.get() = " + (char)buffer.get());
        }
        buffer.clear();*/


        //ByteBuffer buffer = Charset.forName("UTF-8").encode("sunshuai");
        //
        //System.out.println("buffer.capacity() = " + buffer.capacity());//8
        //System.out.println("buffer.position() = " + buffer.position());//0
        //System.out.println("buffer.limit() = " + buffer.limit());//8
        //
        //buffer.flip();
        //
        //System.out.println("---------------------------------");
        //
        //System.out.println("buffer.capacity() = " + buffer.capacity());
        //System.out.println("buffer.position() = " + buffer.position());
        //System.out.println("buffer.limit() = " + buffer.limit());
        //
        //
        //while (buffer.hasRemaining()) {
        //    System.out.println("buffer.get() = " + (char) buffer.get());
        //}
        //buffer.clear();


    /*    ByteBuffer buffer = StandardCharsets.UTF_8.encode("sunshuai");

        while (buffer.hasRemaining()) {
            System.out.println("buffer.get() = " + (char) buffer.get());
        }
        buffer.clear();*/

        ByteBuffer buffer = ByteBuffer.wrap("sunshuai".getBytes());
        while (buffer.hasRemaining()) {
            System.out.println("buffer.get() = " + (char) buffer.get());
        }
        buffer.clear();
    }

}
