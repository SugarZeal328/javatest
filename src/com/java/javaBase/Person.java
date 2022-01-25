package com.java.javaBase;

public class Person {

    private int age;

    //类的构造器：权限修饰符 ＋ 类名（形参）
    public Person(int age){
        this.age = age;
        System.out.println(age);
    }

    //通常会提供一个空参的构造器
    public Person(){

    }

    public Person(String str, int age){
        this(age);
        System.out.println("构造器的重载");
    }

    public void setAge(int age) {
        if (age < 0 || age > 130) {
            //throw new RuntimeException("传入非法数据")
            System.out.println("传入非法数据");
            return;
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
