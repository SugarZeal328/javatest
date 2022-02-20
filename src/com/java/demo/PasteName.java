package com.java.demo;

public class PasteName {
    int puppyAge;
    public PasteName(String name) {
        System.out.println("Paste Name is:" + name);
    }

    public void setAge(int age){
        puppyAge = age;
    }
    public int getAge(){
        System.out.println("sugar zeal's age is" + puppyAge);
        return puppyAge;
    }

    public static void main(String []args){
        PasteName myPastName = new PasteName("sugar zeal");
        myPastName.setAge(22);
        myPastName.getAge();
        System.out.println(myPastName.puppyAge);
    }
}
/*
1.一个源文件中只能有一个public类，多个非public类
2.源文件名称应和public类保持一致
 */