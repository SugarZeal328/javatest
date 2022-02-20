package com.java.javaBase;

public class Recursion {
    public static void main(String[] args){
        Recursion res = new Recursion();
        int a1 = res.getProduct(3);

        System.out.println(a1);

        int a2 = res.fucntionF(2);
        System.out.println(a2);

        int a3 = res.Fibonacci(6);
        System.out.println(a3);



    }

    //例1 计算1-n之间所有自然数的乘积：n!
    public int getProduct(int n) {
        if(n == 1) {
            return n;
        }else {
            return n * getProduct(n - 1);
        }
    }

    //已知有一个数列，f(0) = 1, f(1) = 4, f(n+2) = 2*f(n+1) + f(n),
    // n是大于0的整数，求f(10)的值
    public int fucntionF(int n){
        if (n == 0){
            return 1;
        }else if (n == 1){
            return 4;
        }else {
            return 2 * fucntionF(n - 1) + fucntionF(n - 2);
        }
    }

    //斐波那契数列: 一个数等于前两个数字的之和
    public int Fibonacci(int n){
        if (n == 1 || n == 2){
            return 1;
        }else {
            return Fibonacci(n -2 ) + Fibonacci(n - 1);
        }
    }

    //汉诺塔

    //快速排序
}
