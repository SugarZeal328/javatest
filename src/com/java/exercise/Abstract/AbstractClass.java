package com.java.exercise.Abstract;

public class AbstractClass {

    public static void main(String args[]) {
        //创建了一个抽象类的匿名对象
        Person p = new Person() {
            @Override
            public void eat() {
                System.out.println("🐕‍🦲要吃");
            }
        };//直接在创建的对象后重写所有抽象方法，勿忘分号;

        p.eat();
        p.breath();


    }
}
//抽象类不可实例化
//只有抽象类才可以写抽象方法，防止抽象方法被调用
abstract class Person {
    String name;
    int age;

    //抽象类仍然需要提供构造器，便于子类对象实例化
    public Person(){

    }

    //抽象方法不可写方法体，只有声明
    abstract public void eat();

    public void breath() {
        System.out.println("呼吸");
    }
}

//非抽象子类必须重写父类种所有的抽象方法
class Student extends Person {
    @Override
    public void eat(){
        System.out.println("吃，就知道吃");
    }

}
