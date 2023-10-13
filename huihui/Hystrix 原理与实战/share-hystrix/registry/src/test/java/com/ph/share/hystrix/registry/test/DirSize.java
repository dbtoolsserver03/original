package com.ph.share.hystrix.registry.test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class DirSize {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 文件夹 对应的大小
         * 1        2
         * 2        8
         * 3        19
         *
         * 总计       29
         */

        ReentrantLock lock = new ReentrantLock();
        DirTotalSize dirTotalSize = new DirTotalSize();
        CountDownLatch latch = new CountDownLatch(3);


        new Thread(new TT(dirTotalSize, "/Users/kano/temp/1", lock,latch)).start();
        new Thread(new TT(dirTotalSize, "/Users/kano/temp/2", lock, latch)).start();
        new Thread(new TT(dirTotalSize, "/Users/kano/temp/3", lock, latch)).start();

        System.out.println("start");
        latch.await();
        System.out.println("end");
        new Thread(new Total(dirTotalSize)).start();

    }

    static class TT implements Runnable {
        private DirTotalSize dirTotalSize;
        private String dirPath;
        private ReentrantLock lock;
        private CountDownLatch latch;


        public TT(DirTotalSize dirTotalSize, String dirPath, ReentrantLock lock, CountDownLatch latch) {
            this.dirTotalSize = dirTotalSize;
            this.dirPath = dirPath;
            this.lock = lock;
            this.latch = latch;
        }

        @Override
        public void run() {
            /**
             * 线程 1 2 3
             * 需要在这里调用 DirTotalSize 的 add 方法
             *
             * 需要一个文件夹的路径
             */
            lock.lock();
            try {
                dirTotalSize.add(FileUtils.sizeOfDirectory(new File(dirPath)));
            }finally {
                latch.countDown();
                lock.unlock();
            }
        }
    }

    static class Total implements Runnable {
        private DirTotalSize dirTotalSize;

        public Total(DirTotalSize dirTotalSize) {
            this.dirTotalSize = dirTotalSize;
        }

        @Override
        public void run() {
            /**
             * 线程 4 需要在这里调用
             * DirTotalSize 的 getTotalSize 方法
             */
            System.out.println("总大小：" + dirTotalSize.getTotalSize());
        }
    }

    static class DirTotalSize {
        private volatile long totalSize;

        public void add(long size) {
            totalSize += size;
        }

        public long getTotalSize() {
            return totalSize;
        }

    }
}


