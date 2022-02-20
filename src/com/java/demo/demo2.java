package com.java.demo;
import java.util.*;
import java.text.*;

public class demo2 {
    int a;
    int age;

    public demo2(int a) {
        this.a = a;
    }

    public void setage(int b) {
        age = b;
    }

    public void pupAge() {
        age = age + a;
        System.out.println(age);
    }

    public static void main(String[] args) {


        Integer a = 1;
        Integer b = 1;
        System.out.print(a==b);
        a=300;
        b=300;
        System.out.print(a);
        System.out.print(b);
        System.out.print(a==b);
        //int x = 10;
        //while循环
        /*
        while (x < 20) {
            System.out.println("value of x :" + x);
            x++;
            System.out.println();
        }
        */
        /*
        //while循环如果不满足条件则不能进入循环，而do while至少能执行一次
        do {
            System.out.println("value of x :" + x);
            x++;
            System.out.println();
        } while (x < 10);
         */
        //for循环，for循环的执行次数在执行前就已经确定
        /*
        for(; x < 20; ++x){
            System.out.println("value of x:" +x);
        }
        System.out.println(++x);//++x 先加1在输出
        System.out.println(x++);//x++ 先输出在加
        System.out.println(x);
        */
        //java增强for循环，用于数组的增强型for循环
        /*
        int [] numbers = {10, 20, 30, 40, 50};
        for (int a : numbers){
            System.out.print( a );
            System.out.print(",");
        }
        System.out.println("\n");

        String [] names ={"Jame", "Larry", "Tom", "Lacy"};
        for( String name : names ) {
            System.out.print( name );
            if(name == "Lacy"){
                break;
            }//break关键字，跳出整个循环
            System.out.print(",");
        }
        System.out.println("\n");
        for(int b : numbers){
            if (b != 30){
                continue;
            }//continue关键字，立即跳转到更新语句
            System.out.print(b);
            System.out.print("\n");
        }
         */

       /*if else语句
       int y = 30;
        if(y == 10){
            System.out.println("value of y is " + y);
        }else if(y == 20){
            System.out.println("value of y is " + y);
        }else if(y == 30){
            System.out.println("value of y is " + y);
        }
        */

        /*switch语句
        1.switch语句中的变量类型只能为byte，short，int,或者char，Java7后支持String
        2.switch后可以跟多个case语句，每个case后跟一个要比较的值和冒号
        3.变量值与case值相等，开始执行。只到break语句出现才会跳出
        4.没有break语句，程序会继续执行下一条 case 语句，直到出现 break 语句
        5.switch 语句可以包含一个 default 分支，该分支必须是 switch 语句的最后一个分支。default 在没有 case 语句的值和变量值相等的时候执行。default 分支不需要 break 语句。
         */

        /*
        char grade = 'C';
        switch (grade) {
            case 'A':
                System.out.println("GOOD");
                break;
            case 'B':
            case 'C':
                System.out.println("NORMAL");
                break;
            case 'D':
                System.out.println("PASS");
                break;
            case 'F':
                System.out.println("NOT PASS");
                break;
            default:
                System.out.println("grade error");
        }
        System.out.print("your grade" + grade);

         */
        /*
        //Java Number类
        //一般情况下常用的基本数据类型：byte，int，short，long，double，float，boolean，char;
        //对应的包装也有8类：Byte、Integer、Short、Long、Double、Float、Character、Boolean;
        //包装类型都是用 final 声明了，不可以被继承重写；在实际情况中编译器会自动的将基本数据类型装箱成对象类型，
        // 或者将对象类型拆箱成基本数据类型；如下：
        int num1 = 1;
        Integer num2 = new Integer(2);
        Integer num3 = 3;
        //将对象数据拆箱
        int num4 = num3;
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        //包装类的意义：https://blog.csdn.net/qq_33592002/article/details/90582511
         */

        //StringBuffer类与StringBuilder类:与String类不同，StingBuffer与StringBuilder类的对象可多次被修改而不产生新的对象
        /*StringBuffer sBuffer = new StringBuffer("test");
        sBuffer.append(" StringBuffer类调用String类的方法");
        System.out.println(sBuffer);
         */
        /*
            StringBuffer类与StringBuilder类最大的不同是前者的方法是线程安全的，
        （线程安全就是多线程访问时，采用了加锁机制，当一个线程访问该类的某个数据时，
        进行保护，其他线程不能进行访问直到该线程读取完，其他线程才可使用。不会出现
        数据不一致或者数据污染。线程不安全就是不提供数据访问保护，有可能出现多个线
        程先后更改数据造成所得到的数据是脏数。
            StringBuilder相较于StingBuffer拥有速度优势，因此在不要求线程安全
        的情况下使用前者。
         */
        /*

        //java数组
        int[] intArray = new int[3];
        int toolArray[] = {1,2,3};
        for(int i : toolArray){
            intArray[i-1] = toolArray[i-1];
        }

        for(int i = 0; i<intArray.length; i++){
            System.out.println(intArray[i] + "");
        }
        System.out.println();
        //数组作为参数
        printArray(new int[]{1, 2, 3});
        System.out.println();

        System.out.println(reverse(new int[]{4, 2, 3, 6})[0]);

        //使用toString函数显示日期时间
        dateDemo date = new dateDemo();
        System.out.println(date.date.toString());
        //日期比较函数：befor(); after(); equals();
        boolean[] booleansTroop = new boolean[3];
        booleansTroop[0] = date.date.before(new Date(99,3,18));
        booleansTroop[1] = date.date.equals(new Date(99,3,18));
        booleansTroop[2] = date.date.after(new Date(99,3,18));
        for(boolean i : booleansTroop){
            System.out.println(i);
        }
        //SimpleDateFormat格式化时间
        dateDemo1 simpleDF = new dateDemo1();
        Date dNow = new Date();
        System.out.println(simpleDF.ft.format(dNow));
        //printf格式化日期
        //使用toString()显示日期时间
        String str  = String.format("现在是：%tc ", dNow);
        System.out.printf(str);

         */

    }



    //将数组作为参数
    public static void printArray(int[] array) {
        for(int i = 0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }

    //将数组作为返回对象


    public static int[] reverse(int[] list){
        int[] result = new int[list.length];

        for(int i = 0, j = result.length - 1; i < list.length; i++, j--){
            result[j] = list[i];
        }

        return result;
    }
}

class dateDemo{
    Date date = new Date();
}

class dateDemo1 {
    //转为 星期 年月日 at 时分秒 AM/PM 时区 星期二 2021.09.07 at 05:46:13 下午 CST
    SimpleDateFormat ft =
            new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
}


