package com.java.exercise;

public class ToStringTest {
    String str;

    public ToStringTest(){
    }

    public ToStringTest(String str) {
        this.str = str;
    }

    @Override//自动重写toString方法
    public String toString() {
        return "ToStringTest{" +
                "str='" + str + '\'' +
                '}';
    }

    public static void main(String[] args){

        ToStringTest strt = new ToStringTest("zzz");
        System.out.println(strt.toString());//未重写则输出地址值
        System.out.println(strt.str.toString());//String类中重写了方法，输出字符串值
    }
}
