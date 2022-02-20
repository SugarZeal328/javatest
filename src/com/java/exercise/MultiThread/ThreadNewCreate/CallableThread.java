package com.java.exercise.MultiThread.ThreadNewCreate;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/*
创建线程的方式3和4
1.实现callable接口，重写call()方法
 */
public class CallableThread {

    public static void main(String[] args) {

        CallThread ct1 = new CallThread();

        FutureTask futureTask = new FutureTask(ct1);

        //通过Thread让线程启动
        Thread t1 = new Thread(futureTask);

        t1.start();

        try{
            //get()方法得到的是FutureTask参数ct1重写的call()方法的返回值
            Object sum = futureTask.get();
            System.out.println("1到100的偶数总和" + sum);

        }catch (InterruptedException e){
                 e.printStackTrace();

        }catch (ExecutionException e){
                e.printStackTrace();

        }
    }
}

class CallThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i<= 100; i++){

            if (i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;//int不是objec的子类，通过自动装箱转换
    }
}