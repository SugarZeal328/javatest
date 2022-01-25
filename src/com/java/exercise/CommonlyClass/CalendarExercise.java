package com.java.exercise.CommonlyClass;

import org.junit.Test;

import java.lang.reflect.Array;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.Callable;

/*
Calendar 抽象类，不可实例化
 */
public class CalendarExercise {



    @Test
    public void test() {
        //1.通过子类对象
        Calendar c1 = new GregorianCalendar();
        //2.通过静态方法返回子类对象
        Calendar c2 = Calendar.getInstance();

        //常用方法
        System.out.println(c1.get(Calendar.DAY_OF_YEAR));//今天是本月的第几天
        System.out.println(c2.getTime());//转为Date类
        long num = 86400000;
        Date date = new Date(num);
        c2.setTime(date);//将Date类对象的值传入Calendar的子类对象
        System.out.println(c2.getTime());

        //Instant类：时间上的一个瞬间，用来记录应用程序中的事件时间戳
        Instant ins = Instant.now();
        System.out.println(ins);
        //设置时区偏移量:atOffSet()
        OffsetDateTime ofst = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println(ofst);
        //获取对应的毫秒数
        long num1 = ins.toEpochMilli();
        System.out.println(num1);
        //通过毫秒或者秒数数创建Instant对象
        Instant ins1 = Instant.ofEpochSecond(1942759115);
        System.out.println(ins1);


    }

    @Test
    public void test1() {
        //DateTimeFormatter 格式化或解析日期，时间

        //实例化方式1：预定义的标准格式
        DateTimeFormatter dtfm = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期--→字符串
        LocalDateTime ldt  = LocalDateTime.now();
        String str1 = dtfm.format(ldt);
        System.out.println(str1);

        //解析：字符串--→日期

    }


}
