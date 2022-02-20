package com.java.javaBase;

public class PersonTest {

    public static void main(String[] args){
        Person p1 = new Person(13);
        Person p2 = new Person("constructor overload", 1);
        //p1.age 无法访问
        //通过方法获取私有成员变量
        //p1.setAge(12);
        //System.out.println(p2.getAge());
    }


}
