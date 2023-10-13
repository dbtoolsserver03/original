package com.ph.share.share.quartz.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DFUtil {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String format(Date date) {
        return sdf.format(date);
    }
}
