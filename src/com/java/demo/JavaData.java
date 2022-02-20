package com.java.demo;

import java.util.Date;
import java.text.*;

public class JavaData {
    public static void main(String []args){
       /*
        Date data = new Date();//实例化对象，获取当前时间
        //toString()函数显示时间
        System.out.println(data.toString());
        */

        /*
        Java日期比较的三种方法
        1.使用getTime()方法获取两个日期，然后比较
        2.使用before()，after()，equals()。
        3.使用compareTo()方法
         */

        Date date1 = new Date(1999,2,27);
        Date date2 = new Date(2004,12,22);
        //System.out.println(date1.before(date2));

        //SimpleDateFormat格式化日期
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd HH:mm:ss ZZZ");

        Date date3 = new Date();
        System.out.println("Current Date is " + ft.format( date3 ));
    }
}
