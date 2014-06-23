package com.licong.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * Created by lctm2005 on 2014/5/31.
 */
public abstract class DateUtil {

    private static final SimpleDateFormat FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat FORMAT_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 转换为yyyy-MM-dd
     * @param date  日期
     * @return
     */
    public static String formatDate(Date date) {
        return FORMAT_DATE.format(date);
    }

    /**
     * 转换为yyyy-MM-dd HH:mm:ss
     * @param date  日期
     * @return
     */
    public static String formatTime(Date date) {
        return FORMAT_TIME.format(date);
    }

    /**
     * 转换为Date
     * @param date  yyyy-MM-dd
     * @return
     */
    public static Date paserDate(String date) {
        try {
            return FORMAT_DATE.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 转换为Date
     * @param time  yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date paserTime(String time) {
        try {
            return FORMAT_TIME.parse(time);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 转换Date为 yyyy-MM-dd 00:00:00
     * @param date from new Date()
     * @return
     */
    public static Date paserDate(Date date) {
         try {
             return FORMAT_DATE.parse(FORMAT_DATE.format(date));
         }catch (ParseException e) {
             return null;
         }
    }


}
