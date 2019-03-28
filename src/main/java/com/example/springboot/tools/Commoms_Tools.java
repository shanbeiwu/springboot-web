package com.example.springboot.tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * 类中提供部分公共方法
 */
public class Commoms_Tools {
    /**
     * 生成id
     * 生成一个随机uuid
     */
    public static String getid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     *生成当前时间
     */
    public static Date getdate() {
        Calendar calender = Calendar.getInstance();
        calender.get(Calendar.YEAR);//年份
        calender.get(Calendar.MONTH);     //月份
        calender.get(Calendar.DAY_OF_MONTH);      //日期
        calender.get(Calendar.HOUR);
        calender.get(Calendar.MINUTE);
        calender.get(Calendar.SECOND);

        return calender.getTime();
    }

    public static long dateToNumber(Date date) {
        String date_number = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
        return  Long.parseLong(date_number);
    }

    public static void main(String[] args) {
        //System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getdate()));
        System.out.println(dateToNumber(getdate()));
    }
}
