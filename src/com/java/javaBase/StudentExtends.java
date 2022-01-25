package com.java.javaBase;

public class StudentExtends extends Student {
    String major;
    /*
    属性和方法可以继承，构造器无法继承
    优点：1.减少代码冗余，提高复用。 2.便于功能扩展
     */
    public StudentExtends(String name, String major, int age){

        this.name = name;
        this.age = age;
        this.major = major;

    }



    public static void main(String[] args){

        StudentExtends student2 = new StudentExtends("panniwan", "CS", 21);
        student2.eat();
        student2.setNum(1);
        System.out.println(student2.getNum());


    }
}

