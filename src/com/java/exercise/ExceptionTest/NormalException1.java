package com.java.exercise.ExceptionTest;
/*
Error: java虚拟机无法解决的严重问题，如JVM内部错误，资源耗尽等情况，一般不编写针对性处理
Exception: 其他因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性代码处理
           如：空指针访问，试图读取不存在的文件，网络连接中断，数组角标越界等
子类重写的方法类型抛出的异常类型不大于父类 ，如果父类中被重写的方法没有throws方式
处理异常，那么子类中的重写方法也不能使用throws，必须使用try-catch-finally方式处理
 */

import com.java.demo.PasteName;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.zip.DataFormatException;


public class NormalException1 {
    public static void main(String[] args)  {
        //java.lang.StackOverflowError 无限创建args，栈溢出
        //main(args);

        //OutOfMemoryError 堆溢出
        //Integer[] arr = new Integer[1024*1024*1024];

        //NullPointerException
        //int arr[] = null;
        //System.out.println(arr[0]);

        //ClassCastException
        //Object obj = new Date();
        //String str = (String)obj;

        //异常处理的方式
        //try-catch-finally:自己处理
        //throws + 异常类型：报异常

        /*
        异常处理：抓抛模型
        抛：当程序在执行过程中出现异常，就会生成一个异常类对应的对象。抛出对象后，其后的代码不再执行
        抓：异常的处理方式：1.try-catch-finally  2.throws new 异常类型

        try{
            //可能出现异常的代码

        }catch(异常类型1 变量名1){
            //一旦异常匹配到形参的异常类，就执行catch中的语句，执行完后
            //继续执行其后的代码
            //Catch中的异常类型如果没有子父类关系，则声明顺序无影响
            //若有子父类关系，则子类必须在父类上
            //在try结构中声明的变量，在结构外不能调用
            //try-catch-finally可以嵌套
            体会1：try-catch-finally处理编译时异常，使得程序出错时就不再报警
            但运行时仍可能出错，相当于使用try-catch-finally将一个编译时可能
            出现的异常延迟到运行时出现
            体会2：开发中运行时异常比较常见，所以我们通常不针对运行时异常编写try-catch-finally
            针对编译时异常，我们说一定要考虑异常处理
        }
        }finally{
            1.一定会执行的代码。finally可不写
            2.即使catch中出现了异常或有return语句，也不会影响finally中
              语句的执行
            3.数据库连接，输入输出流，网络编程socket等JVM无法自动回收
              必须进行手动释放，此时资源释放就声明在finally中
        }
         */
        //int num = NormalException1.exceptionTest1();
        //System.out.println(num);
        //NormalException1.exceptionTest2();

        try {
            NormalException2.exceptionTest1();
        }catch (DataFormatException e){
            e.printStackTrace();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static int exceptionTest1(){
        try {
            Object obj = new Date();
            String str = (String)obj;
            //出现异常后，代码块中异常后的语句将不再被执行
            return 1;
        }catch (ClassCastException e){
            System.out.println("类型异常");
            //System.out.println(e.getMessage());
            e.printStackTrace();//显示异常出现的位置，打印异常信息
            //System.out.println(1/0);
            //出现异常后，代码块中异常后的语句将不再被执行
            return 2;
        }catch (Exception e){
            System.out.println("父类异常类型必须在子类异常类型下面");
        }finally {
            /*finally中的语句一定会被执行，catch中的1/0是算术异常，
              若不写finally,则程序到此结束
             */
            System.out.println("*********");
            return 3;


        }
    }

    public static void exceptionTest2() {
        FileInputStream fis = null;
        try {
            File file = new File("C:\\Users\\张宗中\\IdeaProjects\\java test\\src\\com\\java\\exercise\\ExceptionTest\\hello.txt");
            fis = new FileInputStream(file);

            int data = fis.read();
            while (data != -1){
                System.out.print((char)data);
                data = fis.read();
            }
        }catch (FileNotFoundException e ){
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
                System.out.println("输入流已关闭");
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}

class NormalException2{
/*
    throws + 异常类型：把异常往上抛，不处理
 */
    public static void exceptionTest1() throws DataFormatException, FileNotFoundException, IOException{
        File file = new File("C:\\Users\\张宗中\\IdeaProjects\\java test\\src\\com\\java\\exercise\\ExceptionTest\\hello.txt");
        FileInputStream fis = new FileInputStream(file);

        int data = fis.read();
        while (data != -1){
            System.out.print((char)data);
            data = fis.read();
        }
        fis.close();
    }

    public static void exceptionTest2() {
        try {
            exceptionTest1();
        }catch (DataFormatException e){
            e.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

