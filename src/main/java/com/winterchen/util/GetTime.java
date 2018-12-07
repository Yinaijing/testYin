package com.winterchen.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GetTime {
    /**
     *
     * @param sec 向前或者后推移的秒数。
     * @return 获得一个向前或者向后推算的字符串的datetime。
     */
    public static String getDateTime(Date stod,int sec){
        Calendar c = new GregorianCalendar();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        c.setTime(stod);
        c.add(Calendar.SECOND,sec);
        stod = c.getTime();
        return f.format(stod);
    }

    public static void main(String[] args){

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        System.out.println(f.format( d ));
        System.out.println(getDateTime(d,-1*1));

    }
    /*public static String getDateTime(String datetime,int sec){
        Calendar c = new GregorianCalendar();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date stod = f.parse(datetime, pos);
        c.setTime(stod);
        c.add(Calendar.SECOND,sec);
        stod = c.getTime();
        return f.format(stod);
    }*/
}
