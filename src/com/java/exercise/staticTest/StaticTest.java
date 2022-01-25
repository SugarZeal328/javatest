package com.java.exercise.staticTest;

public class StaticTest {

    public static void main(String[] args){

        Chinese c1 = new Chinese("姚明",40);
        Chinese c2 = new Chinese("张继科",33);

        c1.nation = "CN";
        //多个对象共享一个静态变量，当通过一个对象修改静态变量时，会导致其他对象的静态变量被修改

        System.out.println(c2.toString());


    }
}

class Chinese{
    String name;
    static String nation = new String("UK");//static变量可修改
    int age;


    public Chinese(){

    }

    public Chinese(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Chinese{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", nation='" + nation +'\'' +
                '}';
    }

    public static void show(){
        System.out.println(Chinese.nation);
        /*
        1.静态方法只能调用静态方法和属性
        2.静态方法不能使用this和super关键字
        这是由static变量和方法的生命周期决定的，随着类的加载而加载，早于对象
         */
    }
    //静态代码块会随着类的加载而执行
    static{

        System.out.println("静态代码块随着类的加载而执行，除非重新加载，否则只执行一次");

    }

    {
        System.out.println("非静态代码块随着对象的创建而执行，创建一次执行一次");
    }

}
