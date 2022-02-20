package com.java.exercise.InterfaceTest;

import java.util.regex.Pattern;

/*
1.使用interface来定义
2.Java中接口和类是并列的结构
3.接口的定义和成员
    3.1 JDK7及之前：只能定义全局全量和抽象方法
        全局常量：public static final(自动默认，可以省略不写)
        抽象方法：public abstract（自动默认，可以省略不写）
    3.2 JDK8除了定义全局变量和抽象方法外，还可以定义静态方法，默认方法
4.接口中不可定义构造器（不可实例化）
5.JAVA开发中，通过implements(实现)在类中去实现接口，如果实现类重写（实现）了接口中的
   所有抽象方法，则可实例化，否则应定义为abstract
6.Java类可以实现多个接口，弥补Java单继承性的缺陷
   格式：class Plane extends Object implements Flyble,Attackble{}
7.接口与接口之间可以多继承 interface AA extends BB,CC{}
8.接口具体的属性体现了动态性，接口就是规范，定义的是一组规范，体现了“如果你是/要，
  则必须能……”的思想（能不能的关系）。
9.接口的本质是契约，标准和规范

抽象类与接口与哪些异同？

 */
public class InterfaceTest {

    public static void main(String args[]){
        Plane pl1 = new Plane();
        pl1.defaultFunction();

        System.out.println(Flyble.MAX_SPEED);
    }

}

//先继承父类，后实现接口
class Plane extends Object implements Flyble,Attackble {
    @Override
    public void fly() {
        System.out.println("爷能飞");
    }

    @Override
    public void crack() {
        System.out.println("Mayday");
    }
}

interface Flyble{

    //全局常量
    public static final double MAX_SPEED = 7.9;
    double MIN_SPEED = 1.0;

    //抽象方法
    abstract public void fly();
    void crack();

    //静态方法，实现类无法继承
    static void staticFunction(){

    }

    //默认方法
    default void defaultFunction(){

    }

}

interface Transble{

}

//接口间多继承关系
interface Attackble extends Flyble, Transble{

}