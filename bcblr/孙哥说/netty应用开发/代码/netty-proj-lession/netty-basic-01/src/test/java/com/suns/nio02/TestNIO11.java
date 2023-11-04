package com.suns.nio02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class TestNIO11 {
    public static void main(String[] args) throws IOException {


        //1 获得Channel  FileOutputStream, RandomAccessFile
        FileChannel channel = new FileOutputStream("data1").getChannel();

        //2 获得Buffer
        ByteBuffer buffer = Charset.forName("UTF-8").encode("sunshuai");

        //3write
        channel.write(buffer);

    }
}
