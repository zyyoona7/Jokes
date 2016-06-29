package com.zyyoona7.jokes.utils;

import java.util.Date;

/**
 * Created by User on 2016/6/29.
 */

public class TimeUtils {


    /**
     * 获取当天0点的秒值
     *
     * @return
     */
    public static String getTodayZero() {
        Date date = new Date();
        long l = 24 * 60 * 60 * 1000; //每天的毫秒数
        //date.getTime()是现在的毫秒数，它 减去 当天零点到现在的毫秒数（ 现在的毫秒数%一天总的毫秒数，取余。），理论上等于零点的毫秒数，不过这个毫秒数是UTC+0时区的。
        //减8个小时的毫秒值是为了解决时区的问题。
        long today = (date.getTime() - (date.getTime() % l) - 8 * 60 * 60 * 1000);
        return String.valueOf(today / 1000);
    }

    /**
     * 获取这周0点的秒值
     *
     * @return
     */
    public static String getWeekZero() {
        Date date = new Date();
        long l = 24 * 60 * 60 * 1000 * 7; //每周的毫秒数
        //date.getTime()是现在的毫秒数，它 减去 当天零点到现在的毫秒数（ 现在的毫秒数%一天总的毫秒数，取余。），理论上等于零点的毫秒数，不过这个毫秒数是UTC+0时区的。
        //减8个小时的毫秒值是为了解决时区的问题。
        long week = (date.getTime() - (date.getTime() % l) - 8 * 60 * 60 * 1000);
        return String.valueOf(week / 1000);
    }

    /**
     * 获取这月0点的秒值
     *
     * @return
     */
    public static String getMonthZero() {
        Date date = new Date();
        long l = 24 * 60 * 60 * 1000 * 30; //每月的毫秒数
        //date.getTime()是现在的毫秒数，它 减去 当天零点到现在的毫秒数（ 现在的毫秒数%一天总的毫秒数，取余。），理论上等于零点的毫秒数，不过这个毫秒数是UTC+0时区的。
        //减8个小时的毫秒值是为了解决时区的问题。
        long month = (date.getTime() - (date.getTime() % l) - 8 * 60 * 60 * 1000);
        return String.valueOf(month / 1000);
    }
}
