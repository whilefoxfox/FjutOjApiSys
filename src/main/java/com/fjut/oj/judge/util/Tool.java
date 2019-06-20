package com.fjut.oj.judge.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tool {

    public static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {}
    }

    public static String nowDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

    public static Timestamp now(){
        return new Timestamp(System.currentTimeMillis());
    }

}
