package com.java.exercise;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

import static org.junit.Assert.*;

/*
1.八种基本数据类型包装类，使得基本数据类型的变量有了类的特征
2.jdk5.0新特性支持自动装箱和拆箱
 */
public class WrapperTest {

    @Test
    public void test1(){
        Integer num1 = new Integer(1);//装包
        int i1 = num1.intValue();//拆包

        int i2 = 1;
        Integer num2 = i2;//自动装箱
        int i21 = num2;//自动拆箱

        Boolean b1 = new Boolean(true);//true or false
        Boolean b2 = new Boolean("true123");//也可以是个字符串，只要是true就是true，其他的全为false

        //包装类转为String
        String str1 = num1 + "";//连接运算
        String.valueOf(num1);//调用valueOf()方法

        //String转为基本数据类型和包装类
        String str2 = "123";
        //调用包装类中的parseXxx()
        int num3 = Integer.parseInt(str2);


                /*
                public Boolean(String s) {
        this(parseBoolean(s));
    }
                 */
    }

    @Test
    public void interviewTest1(){
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println("********" + o1 + "********");
        //输出1.0 o1的编译类型要统一，自动上升为double类

        Object o2;
        if (true) o2 = new Integer(1);
        else o2 = new Double(2.0);
        System.out.println("********" + o2 + "********");
        //输出1，不要求统一类型

        }

     @Test
    public void interviewTest2(){
         Integer i = new Integer(1);
         Integer j = new Integer(1);
         System.out.println(i == j);//false
         System.out.println(i.equals(j));//true, 对象比较地址

         /*
         Integer内部定义了一个IntegerCache结构，IntegerCache中
         定义了Integer[]，保存了从-128到127的整数，如何使用自动装箱
         给Integer的赋值在-128~127时，可以直接使用数组中的元素，不用去new
         提高了效率
          */

         Integer m = 1;
         Integer n = 1;
         System.out.println(m == n);//true，1在内存池的范围内

         Integer m1 = 128;
         Integer n1 = 128;
         System.out.println(m1 == n1);//false
         // 出了内存池的范围[-128,127]，必须new对象
     }



}

/*
利用Vector代替数组处理，从键盘读取学生成绩（以负数代表结束），
找出最高分，并输出学生成绩
 */

