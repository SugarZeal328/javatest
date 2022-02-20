package com.java.demo;

public class JavaStringMethod {
    /*
        当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。
    和String类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，
    并且不产生新的未使用对象。
        StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大
    不同在于 StringBuilder 的方法不是线程安全的（线程安全就是多线程访问时，
    采用了加锁机制，当一个线程访问该类的某个数据时，进行保护，其他线程不能进
    行访问直到该线程读取完，其他线程才可使用。不会出现数据不一致或者数据污染
    线程不安全就是不提供数据访问保护，有可能出现多个线程先后更改数据造成所得到的数据是脏数据）。
        由于 StringBuilder 相较于 StringBuffer 有速度优势，
    所以多数情况下建议使用 StringBuilder 类。然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。
     */
    public static void main (String []args){
        StringBuilder sBuffer = new StringBuilder("test");
        System.out.println(sBuffer);
        System.out.println(sBuffer.reverse());
        System.out.println(sBuffer.replace(0,4,"DUST"));//replace函数替换包括结尾不包括起始
        sBuffer.append(" string Buffer");
        System.out.println(sBuffer);
    }
}
