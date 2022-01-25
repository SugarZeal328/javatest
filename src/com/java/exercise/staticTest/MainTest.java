package com.java.exercise.staticTest;
//一个java文件中可以有多个main方法，静态方法可通过类调用

import java.util.Arrays;

public class MainTest {


    public static void main(String[] args){
        String[] str = new String[1];
        str[0] = "zzz";
        MainDemo1.main(str);
    }


}

class MainDemo1{
     public static void main(String[] args){
        System.out.println(args[0]);
    }
}

/*
可以从控制台与main()方法交互
edit configuration → program arguments → run
 */
class MainDemo2{
    public static void main(String[] args){
       System.out.println(Arrays.toString(args ));
    }
}

