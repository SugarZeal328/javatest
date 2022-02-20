package com.java.javaBase;

import javax.swing.text.html.parser.TagElement;

public class Student {

    String name;
    int age;
    private int num;

    public Student(){

    }

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("恰");
    }

    public void sleep(){
        System.out.println("闭");

    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}



