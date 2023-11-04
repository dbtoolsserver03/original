package com.baizhiedu.util;

public class ThreadLocalUtils {
    private static final ThreadLocal<Page> tl = new ThreadLocal<>();

    public static void set(Page page) {
        tl.set(page);
    }

    public static Page get() {
        return tl.get();
    }
}
