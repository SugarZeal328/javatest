package com.java.exercise.MultiThread;
/*
问题：synchronized和lock的异同
相同：二者都可以解决线程安全问题
不同：lock手动上锁解锁，synchronized手动上锁，自动释放同步监视器
 */
import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        SaleWindow5 sw = new SaleWindow5();

        Thread t1 = new Thread(sw);
        Thread t2 = new Thread(sw);
        Thread t3 = new Thread(sw);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class SaleWindow5 implements Runnable {

    private int ticket = 100;

    //1.创建一个锁对象
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run(){
        while (true) {
            try {
                //2.调用lock方法,确保该过程是个单线程
                lock.lock();

            if (ticket > 0) {

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "" +
                        ": 卖票，余票为：" + ticket--);
            }else break;
        } finally {
                //3.调用解锁方法：unlock()
                lock.unlock();
            }
        }
    }
}