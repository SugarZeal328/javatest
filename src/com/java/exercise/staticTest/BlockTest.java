package com.java.exercise.staticTest;
import org.junit.Test;
import java.util.regex.Pattern;

public class BlockTest {

    static{
        System.out.println("BlockTest static block");
    }

    @Test
    public void blockTest(){

        new Leaf();
        /*
        1.先加载类，运行static代码块，父类加载完毕，加载子类，
        2.创建父类对象，运行父类非静态代码块，运行父类构造器中语句
        3.创建子类对象，运行子类非静态代码块，运行子类构造器中语句
        4.static代码块中必须使用静态属性和静态方法
        root static block
        mid static block
        leaf static block
        root instatic block
        creating root object
        mid instatic block
        creating mid object
        leaf instatic block
        creating leaf object

         */

    }

}

class Root{

    public Root(){
        System.out.println("creating root object ");
    }

    static {
        System.out.println("root static block");
    }

    {
        System.out.println("root instatic block");
    }
}

class Mid extends Root{

        int i = 0;

    public Mid(){
        System.out.println("creating mid object ");
    }

    static {
        System.out.println("mid static block");
    }

    {
        System.out.println("mid instatic block");
    }
}

class Leaf extends Mid{

    public Leaf(){
        System.out.println("creating leaf object ");
    }

    static {
        System.out.println("leaf static block");
    }

    {
        System.out.println("leaf instatic block");
    }
}

