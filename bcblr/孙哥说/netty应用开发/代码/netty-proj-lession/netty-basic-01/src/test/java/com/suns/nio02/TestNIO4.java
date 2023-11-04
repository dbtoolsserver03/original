package com.suns.nio02;

import org.junit.Test;

import java.nio.ByteBuffer;

public class TestNIO4 {

    @Test
    public void testState5() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});

        buffer.flip();
        System.out.println("buffer.get() = " + (char)buffer.get());//a
        System.out.println("buffer.get() = " + (char)buffer.get());//b

        System.out.println("buffer.capacity() = " + buffer.capacity());//10
        System.out.println("buffer.position() = " + buffer.position());//2
        System.out.println("buffer.limit() = " + buffer.limit());//4

        System.out.println("-----------------------------------------------");
        buffer.compact();

        System.out.println("buffer.capacity() = " + buffer.capacity());//10
        System.out.println("buffer.position() = " + buffer.position());//2
        System.out.println("buffer.limit() = " + buffer.limit());//10

        buffer.flip();
        System.out.println("buffer.get(0) = " + (char)buffer.get(0));
        System.out.println("buffer.get(1) = " + (char)buffer.get(1));


    }

    @Test
    public void testState1() {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        System.out.println("buffer.capacity() = " + buffer.capacity());//10
        System.out.println("buffer.position() = " + buffer.position());//0
        System.out.println("buffer.limit() = " + buffer.limit());//10
    }

    @Test
    public void testState2() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});

        System.out.println("buffer.capacity() = " + buffer.capacity());//10
        System.out.println("buffer.position() = " + buffer.position());//4
        System.out.println("buffer.limit() = " + buffer.limit());//10
    }

    @Test
    public void testState3() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});

        buffer.flip();

        System.out.println("buffer.capacity() = " + buffer.capacity());//10
        System.out.println("buffer.position() = " + buffer.position());//0
        System.out.println("buffer.limit() = " + buffer.limit());//4
    }

    @Test
    public void testState4() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});

        buffer.clear();

        System.out.println("buffer.capacity() = " + buffer.capacity());//10
        System.out.println("buffer.position() = " + buffer.position());//0
        System.out.println("buffer.limit() = " + buffer.limit());//10
    }


}
