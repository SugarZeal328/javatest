package com.java.exercise.MultiThread;
//使用两个线程打印1-100，线程1，线程2交替打印
public class ThreadCommunication {

    public static void main(String[] args) {

        Number n1 = new Number();

        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();


        t2.start();
    }

}

class Number implements Runnable {

    private int number = 1;

    @Override
    public void run() {

        while (true){
            synchronized (this) {

                notify();//通知释放锁

                if (number <= 100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()
                    + ":" + number++);
                    try {
                        wait();//等待同步锁，手动阻塞，实现两个线程交替执行
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else break;
            }
        }
    }
}

/*
生产者product将产品交给店员clerk，而消费者customer从店员处取走产品，店员一次只能
持有固定数量的产品，如果生产者试图生产更多的产品，店员会叫停，如果店中有空位放产品再通知生产
如果店中没产品，则会通知消费者等一下，有产品了通知取走
1.生产者比消费者快时，消费者会漏掉一些数据没有取到
2.消费者比生产者快时，消费者会取出相同的数据
 */