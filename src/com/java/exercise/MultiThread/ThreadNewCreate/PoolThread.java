package com.java.exercise.MultiThread.ThreadNewCreate;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/*
创建线程的方式4：线程池
 */
public class PoolThread {

    public static void main(String[] args) {

        //1.创建线程池newFixedThreadPool(10)：创建拥有10个线程的可重复利用的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        /*ExecutorService作为接口本身并无对象，service实际上是一个实现ExecutorService
         *接口的ThreadPoolExecutor类的实例，可以强转，设置属性，实现线程管理
         */

        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;


        //2.执行指定线程的操作，execute适用于Runable, submit适用于Callable
        service1.execute(new THR());//适用于Runable
        service1.submit(new THC());//适用于Callable

        service1.shutdown();//关闭线程

    }



}

class THR implements Runnable {

    @Override
    public void run() {
        int sum = 0;
        for (int i = 1; i<= 100; i++){

            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
    }
}

class THC implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i<= 100; i++){

            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
        return sum;//int不是objec的子类，通过自动装箱转换
    }
}