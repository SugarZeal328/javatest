package com.java.javaBase;

import java.util.Arrays;

/*
方法的重写：override/overwrite
在子类继承父类后，可以对父类同名中的同名同参数的方法，进行覆盖
子类无法对父类的方法进行重载
重写的方法权限不可低于被重写的方法，子类不能重写父类中声明为private的方法
返回值类型
被重写方法： viod     ClassType           基本数据类型
  重写方法： viod     ClassType或其子类    相同的基本数据类型

 子类重写的方法抛出的异常不大于父类被重写的方法抛出的异常类型
 static方法无法被重写
 */


class Human{

    String name;
    int age;
    int id;

    public Human(){

    }



    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("恰");
    }
    public void eat(String ... strs){
        System.out.println(Arrays.toString(strs));
    }
    public void walk( int distance ){
        System.out.println("walk " + distance + "KM");
    }
}

class Man extends Human{
    String job;


    public Man() {

        // 如果在类中你提供了其他有参的构造器，则编译器不会提供默认的无参构造器
        //因此，如果当父类中的空构造器被注销后，子类的构造器会报错因为此时super()不再存在
    }

    public Man(String name, String job, int age) {
        super(name, age);//super关键字调用父类中的构造器
        this.job = job;
    }

    public void eat(){
        System.out.println("随便恰");
        super.eat();//调用父类钟被重写过的方法
    }

}

class OverRideTest{
    public static void main(String[] args){

        Human h1 = new Human("zzz",23);
        Man m1 = new Man("pnw","student", 21);

        String[] str = new String[3];
        for (int i = 0; i < str.length; i++){
            str[i] = String.valueOf(i);

        }

        h1.eat();
        h1.eat(str);
        m1.eat();
        System.out.println(m1.name);



    }

}