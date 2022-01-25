package com.java.exercise.CommonlyClass;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateExercise {
    @Test
    public void simpleDateFormatTest() throws ParseException {
        //simpleDateFormat
        //1.实例化
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期--→字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：字符串--→日期
        String str = "2021--10--09 上午11:12";
        Date date2 = sdf.parse(str);

        System.out.println(date2);

        //通过自定义格式创建对象:yyyy.MM.dd
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        //解析字符串
        Date date3 = sdf1.parse("2022-01-19");
        System.out.println(date3);

        //转换为java.sql.Date, 构造器中的java.util.Date调用getTime()方法
        java.sql.Date birthday = new java.sql.Date(date3.getTime());
        System.out.println("出生日期：" + birthday);

        //Date中的偏移量：年份从1900开始，月份从0开始（0代表1月）
        Date date4 = new Date(2022-1900, 0, 21);
        System.out.println(date4);




    }

}

/*
练习：三天打鱼两天晒网 1990-01-02 xxxx-xx-xx 打鱼？晒网
难点：计算总天数：
1.日期无法相减，毫秒数可以：(Today.getTime() - date.getTime())/(1000*60*60*24);
2.
总天数%5 == 1，2，3 打鱼
总天数%4 =4，0 晒网
 */
class DateFish {

    public static String start = "1990-01-01";

    public static String fish() {

        Scanner sc = new Scanner(System.in);

        System.out.print("请按照 yyyy-MM-dd 格式输入年月日：");

        String end = sc.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        long num = 0;
        try {
            num = sdf.parse(end).getTime() - sdf.parse(start).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int gap = (int)(num / 86400000);

        String str = null;

        switch (gap % 5){
            case 0:
            case 1:
            case 2:
                str = "打鱼";
                break;

            case 3:
            case 4:
                str =  "晒网";
                break;
        }

        return end + str;
    }

    public static void main(String[] args) {

        System.out.println("update test");
        System.out.println(DateFish.fish());


    }
}