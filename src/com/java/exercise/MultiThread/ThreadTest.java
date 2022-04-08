package com.java.exercise.MultiThread;
import java.lang.Thread;
import java.util.Arrays;

public class ThreadTest {

    public static void main(String args[]){
        //创建thread子类对象
        MyThread1 t1 = new MyThread1();
        Runnable t2 = new MyThread2();

        Thread thread = new Thread(t2);

        //创建thread的匿名类对象
        new Thread(){

            @Override
            public void run() {
                super.run();
            }
        }.start();
        //调用start方法start()，作用：1.启动当前线程 2.调用当前线程中的run()方法
        //给主线程，从线程命名
        Thread.currentThread().setName("main-0");
        t1.setName("Mythread1-0");
        thread.setName("runable");
        //一个对象只能start()一次，创建一个线程
        t1.start();
        thread.start();


        for (int i = 0; i < 10; i++){
            if ((i % 2) != 0) {
                System.out.println(i + Thread.currentThread().getName());
            }
        }
        /*
        多线程
        main方法是主线程，主线程执行到t1.start()，启动分线程
        start()中的run方法与下面的打印输出语句同时执行
         */
    }







}
//多线程的创建
    /*方法1
    1.创建一个继承thread的子类
    2.重写thread类的run方法: 此线程执行的操作声明在run()中
    3.创建子类对象
    4.通过此对象调用start()方法

    启动线程必须使用start()，不能使用run()
    启动线程必须重新创建一个Thread子类对象，调用此对象的start

    方法2
    1.创建一个实现了Runnable接口的类
    2.实现类去实现Runnable中的抽象方法run()
    3.创建此类的对象
    4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
    5.通过Thread类的对象调用start

    对比
    开发中优先选择实现Runnable的接口方式
    1.实现的方式没有类的单继承局限性
    2.实现的方式更适合来处理多个线程共享数据的情况
    联系
    1.两种方式都需要重写run方法，将线程的执行逻辑声明在run中
    2.目前两种方式启动线程都是调用thread类中的start方法

    线程分类
    用户线程和守护线程，守护线程通常是垃圾回收等，随着用户线程的结束而结束，
    通过start()方法前调用thread.setDaemon(true)可以把一个用户线程变为守护线程

    线程的生命周期
    线程的状态 Thread.state
    NEW, RUNNABLE, BLOCK, WAITING, TIMED_WAITING, TERMINATED
    新建，就绪，运行，阻塞，死亡

    start()方法的作用: 1.启动当前线程 2.调用当前线程中的run()方法

    Thread常用方法
    1.start()：启动当前线程，调用当前线程的run()
    2.run():通常需要重写该方法，将创建的线程需要执行的操作声明在此方法中
    3.currentThread():静态方法，返回执行当前代码的线程
    4.getName():获取当前线程的名字
    5.setName():设置当前线程的名字
    6.yield():


     */


class MyThread1 extends Thread {


    public MyThread1() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            if (i%2 == 0) System.out.println(i + MyThread1.currentThread().getName());
        }
    }
}

class MyThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            if (i%3 == 0) System.out.println(i + Thread.currentThread().getName());
        }

    }
}
