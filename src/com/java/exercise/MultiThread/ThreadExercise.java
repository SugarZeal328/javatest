package com.java.exercise.MultiThread;

import java.util.concurrent.locks.ReentrantLock;

/*
银行一个账户，有两个储户分别向同一个账户中存3000，每次存1000，存3次，打印账户余额
1.涉及多线程，两个储户线程
2.共享数据，账户余额

 */
public class ThreadExercise {

    public static void main(String[] args) {

        Account act1 = new Account(0);

        Customer c1 = new Customer(act1);
        Customer c2 = new Customer(act1);

        c1.setName("用户1");
        c2.setName("用户2");

        c1.start();
        c2.start();

    }

}


class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amt) {
        if (amt > 0){
            double bl = this.getBalance();
            balance = bl + amt;
            //加个sleep方便观察
            try{
                Thread.sleep(100);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "存钱成功，余额：" + balance);
        }
    }
}

class Customer extends Thread {

    private Account act;

    //由于是Thread子类，多线程涉及到多个对象，因此需要将lock设置为静态，多个对象公用一个锁
    private static ReentrantLock lock = new ReentrantLock();

    public Customer(Account act) {
        this.act = act;
    }

    @Override
    public void run() {

            for (int i = 0; i < 3; i++) {

                lock.lock();

                    act.deposit(1000);

                lock.unlock();
            }

        }
}