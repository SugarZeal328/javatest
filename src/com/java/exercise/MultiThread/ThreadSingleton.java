package com.java.exercise.MultiThread;
/*
使用同步机制将单例模式中的懒汉式改写为线程安全的
 */
public class ThreadSingleton {
}

class Bank{
    private Bank() {}//私有化构造器仿防止调用

    private static Bank instance = null;

    //避免多个线程同时调用该方法调用共享数据
    public static Bank getBank(){
        //锁在这个位置效率比较高
        synchronized (Bank.class) {
            if (instance == null) {
                instance = new Bank();
            }
        }
        return instance;
    }


}