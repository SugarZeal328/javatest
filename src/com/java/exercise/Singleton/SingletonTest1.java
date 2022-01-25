package com.java.exercise.Singleton;
import org.junit.Test;
/*
单例设计模式：某个类只能在该类内部声明一个对象
单例模式只生成一个实例，减少了系统开销
 */
public class  SingletonTest1 {
    @Test
    public void testBankSingleton(){
        Bank b1 = Bank.getBank();
        Bank b2 = Bank.getBank();

        School s1 = School.getSchool();
        School s2 = School.getSchool();



        //b1和b2的地址值相同
        System.out.println(b1 + "\r\n" + b2);
        System.out.println("******************************************");
        System.out.println(s1 + "\r\n" + s2);
    }

}

//饿汉式-单例实现模式
//在使用之前实例化好
//优点：线程安全，缺点：对象加载时间长
class Bank{

    //1.构造器必须private
    private Bank(){

    }

    //2.内部创建对象
    private static Bank bk1 = new Bank();
    //另一种写法
    // public static final Bank bk2 = new Bank();

    //3.提供公共方法返回类的对象,由于时是静态方法，
    // 该方法返回的对象也必须是静态的
    public static Bank getBank(){
        return bk1;
    }

}

//懒汉式-单例模式实现
//先声明，在使用时实例化
//优点：延迟对象创建，缺点：下列写法线程不安全
class School{

    //1.私有化构造器
    private School(){

    }

    //2.先声明当前类的实例，没用初始化
    private static School sc = null;

    //3.声明public、static的返回当前对象的方法
    //加上synchronized关键字，线程安全
    public synchronized static School getSchool(){
        if (sc == null) sc = new School();//防止对sc多次实例化
        return sc;
    }

}