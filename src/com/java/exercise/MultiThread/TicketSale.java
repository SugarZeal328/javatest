package com.java.exercise.MultiThread;
/*
    创建3个卖票窗口，总票数为100张，使用实现Runable接口的方式
    保证线程安全
 */

public class TicketSale {
    public static void main(String args[]){

        //通过实现接口创建多线程
        /*
        SaleWindow3 window = new SaleWindow3();

        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

         */


        //通过继承Thread创建子类实现多线程
        SaleWindow4 sw1 = new SaleWindow4();
        SaleWindow4 sw2 = new SaleWindow4();
        SaleWindow4 sw3 = new SaleWindow4();

        sw1.setName("窗口1");
        sw2.setName("窗口2");
        sw3.setName("窗口3");

        sw1.start();
        sw2.start();
        sw3.start();


    }
}

class  SaleWindow1 implements Runnable{

    private static int ticket = 100;
    //共用obj同一把锁
    Object obj = new Object();

    @Override
    public void run() {
        /*
        通过synchronized关键字设置同步代码块或监视器解决
        同步代码：操作同步数据得代码
        同步数据：被多个线程共同访问操作的数据
        同步监视器：俗称锁，任何一个类的对象都可以充当锁：synchronized(任意对象) {被监视的同步代码}
        要求多个线程要公用同一个锁
         */
        while (true){
            synchronized (this) {//此时的this代表唯一的SaleWindow1的对象
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }//添加阻塞后，多个线程可能同时进入就绪状态，从而出现重票、负票号等问题
                    //出现了线程安全问题，原因：当个某个线程在操作的过程中，操作未完成，另一个线程又进来
                    //解决方法：当一个线程在操作共享数据时，其他线程不能参与进来，只到其操作完成，即使其出现了阻塞

                    System.out.println(Thread.currentThread().getName() + "" +
                            ": 卖票，余票为：" + ticket--);
                } else {
                    break;
                }
            }
        }
    }
}

class SaleWindow2 extends Thread{

    //同步数据需要注意是否为静态
    private static int ticket = 100;
    //Thread子类需要将obj设置为静态变量，确保每个线程（对象）共用obj同一把锁
    static Object obj = new Object();

    @Override
    public void run() {
        /*
        通过synchronized关键字设置同步代码块或监视器解决
        同步代码：操作同步数据得代码
        同步数据：被多个线程共同访问操作的数据
        同步监视器：俗称锁，任何一个类的对象都可以充当锁：synchronized(任意对象) {被监视的同步代码}
        要求多个线程要公用同一个锁
         */
        while (true){
            synchronized (SaleWindow2.class) {//用当前类充当当前监视器唯一 对象
                if (ticket > 0) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }//添加阻塞后，多个线程可能同时进入就绪状态，从而出现重票、负票号等问题
                    //出现了线程安全问题，原因：当个某个线程在操作的过程中，操作未完成，另一个线程又进来
                    //解决方法：当一个线程在操作共享数据时，其他线程不能参与进来，只到其操作完成，即使其出现了阻塞

                    System.out.println(Thread.currentThread().getName() + "" +
                            ": 卖票，余票为：" + ticket--);
                } else {
                    break;
                }
            }
        }
    }
}

//使用同步方法解决实现Runable接口类的线程安全
class SaleWindow3 implements Runnable{
    private static int ticket = 100;
    public boolean flag = true;

    @Override
    public void run() {
        while (flag){
            show();
        }
    }
    //通过synchronized修饰同步方法确保线程安全，对于非static方法，同步监视器为this
    public synchronized void show(){
        if(ticket > 0){
            System.out.println(Thread.currentThread().getName() +
                    ": 卖票，余票为" + ticket--);
        }else flag = false;
    }
}

//使用同步方法确保继承Thread类的线程安全
class SaleWindow4 extends Thread{
    private static int ticket = 100;
    public static boolean flag = true;

    @Override
    public void run(){
        while (flag){
            show();
        }
    }

    //对于静态方法，同步方法的同步监视器为当前类
    public synchronized static void show(){
        if (ticket > 0){
            try {
                sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    ": 卖票，余票为" + ticket--);
        }else flag = false;
    }
}