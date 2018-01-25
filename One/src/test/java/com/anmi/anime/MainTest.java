package com.anmi.anime;

import java.util.Date;
import java.util.TimeZone;

public class MainTest {

    public static void main(String[] args) {
        TimeZone tz = TimeZone.getTimeZone("Etc/GMT-8");
        TimeZone.setDefault(tz);
        //Wed Sep 27 16:37:43 CST 2017
        System.out.println(new Date());
    }
}
