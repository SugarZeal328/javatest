package com.java.exercise.MultiThread.Exercise;
/*
生产者product将产品交给店员clerk，而消费者customer从店员处取走产品，店员一次只能
持有固定数量的产品，如果生产者试图生产更多的产品，店员会叫停，如果店中有空位放产品再通知生产
如果店中没产品，则会通知消费者等一下，有产品了通知取走
1.生产者比消费者快时，消费者会漏掉一些数据没有取到
2.消费者比生产者快时，消费者会取出相同的数据
分析：
1.线程安全问题，生产者线程，消费者线程
2.共享数据：产品
3.同步机制，三种方法
4.线程通信
 */
public class ProductTest {

    public static void main(String[] args) {
        Clerk ck = new Clerk();

        Producer p1 = new Producer(ck);
        Consumer c1 = new Consumer(ck);

        p1.setName("生产者1");
        c1.setName("消费者1");

        p1.start();
        c1.start();
    }
}


class Clerk {

    private int productCount;
    private int consumeCount;

    //通知生产
    public synchronized void produceProduct(){
        if (productCount < 20){
            productCount++;

            notify();//生产后就可以唤醒消费线程

            System.out.println(Thread.currentThread().getName() + "开始生产第"
                    + productCount + "个产品");


        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    //通知消费
    public synchronized void consumeProduct(){
        if (productCount > 0){
            System.out.println(Thread.currentThread().getName() + "开始消费第"
            + productCount-- + "个产品");

            notify();//消费后就可以唤醒生产

        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

class Producer extends Thread {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + "开始生产");

        while (true){

            clerk.produceProduct();
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + "购买产品");

        while (true){

            clerk.consumeProduct();
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}