package com.ph.share.share.validator;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;

public class TestAny {
    @Test
    public void uni() {
        String s = "\u20320\u33909";
        System.out.println(s);
    }

    @Test
    public void hehe() {
        String str="06:00:00";
        String strS="00:00:00";
        LocalTime localTime = LocalTime.parse(str);
        LocalTime localTimeS = LocalTime.parse(strS);
        System.out.println(Duration.between(localTimeS, localTime).toMillis());





        System.out.println(Duration.ofHours(6).toMillis());
    }
}
