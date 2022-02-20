package com.java.demo;

import java.util.Scanner;
import java.math.*;

public class forTest {
    //输入两个正整数m和n，求其最大公约数和最小公倍数，使用break关键字
    //ex：12和20的最大公约数是4，最小公倍数是60
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        /*
        System.out.print("输入第一个正整数：");
        int m = scan.nextInt();

        System.out.print("输入第二个正整数");
        int n = scan.nextInt();

        //获取两个数中的较小的那个
        int min = (m < n)? m:n;
        //判定约数，不能超过两个数中最小的那个，从大到小寻找
        for(int i = min; i>0; i--){
        if(m % i == 0 && n % i == 0) {
            System.out.println("最大公约数为：" + i);
            break;//找到最大公约数后跳出
        }

        }

        //获取两个数中较大的那个
        int max = (m > n)? m:n;
        //判定公倍数，最小公倍数>=最小的那个
        for(int i = max; i <= m * n; i++){
            if(i % m == 0 && i % n == 0){
                System.out.println("最小公倍数为：" + i);
                break;
            }
        }

         */

        /*
        //打印1~100之间所有奇数的和
        int sumJ = 0;
        int sumO = 0;
        for(int i =0; i <=100; i++){
            if (i % 2 != 0) {
                sumJ = i + sumJ;
            }else {
                sumO = i + sumO;
            }
        }
        System.out.println("奇数和为" + sumJ);
        System.out.println("偶数和为" + sumO);

         */

        /*

        //输出所有的水仙花数，所谓的水仙花数是指一个3位数，其各位上数字立方和等于其本身
        //ex：153 = 1^3 + 3^3 + 5^3
        for(int i = 100; i<1000; i++){
            int bai = i / 100;
            int shi = i % 100 / 10;
            int ge = i % 10;
            if (i == bai*bai*bai + shi*shi*shi + ge*ge*ge){
                System.out.println(i);
            }
        }

         */

        /*

        //do whike 循环
        //遍历100以内的偶数，计算总和和输出个数
        int num = 1;
        int sum = 0;
        int count = 0;
        do {
            if (num %2 == 0){
                sum += num;
                count++;
            }
            num++;
        }while(num <= 100);
        System.out.println(sum);
        System.out.println(count);

         */

        /*
        //从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入为0时结束程序


        int positiveNum = 0;//正数个数
        int negativeNum = 0;//负数个数

        //循环条件无法确定时，用while(true),通过break控制循环
        while (true){     //若使用for循环，则用for(;;) 代替while(true)

            System.out.println("请输入数字，输入0时中止程序：");

            int number = scan.nextInt();

            //判断正负
            if (number > 0){
                positiveNum++;
            }else if (number < 0){
                negativeNum++;
            }else {
                break;
            }

            System.out.println("正数的个数为：" + positiveNum);
            System.out.println("负数的个数为：" + negativeNum);

        }

         */

        /*

        //嵌套循环 9*9乘法表
        for (int i = 1; i <= 9; i++ ){
            for(int j = 1; j <= i; j++){
                System.out.print(j + "*" + i + "=" + i*j);
                System.out.print(" ");
            }
            System.out.println();
        }

         */

        /*

        //100以内的所有质数 只能被1和其本身整除的自然数
        long start1 = System.currentTimeMillis();
        int count1 = 0;
        for(int i = 2; i<100000; i++){
            boolean isFlag = false;

            for (int j = 2; j < i; j++){
                if (i % j == 0){
                    isFlag = true;
                }

            }
            if (isFlag == false){
                count1++;
            }
        }
        System.out.println();
        long end1 = System.currentTimeMillis();
        System.out.println(count1);
        System.out.println(end1 - start1);

        //输出质数，优化1
        long start2 = System.currentTimeMillis();
        int count2 = 0;
        for(int i = 2; i<100000; i++){
            boolean isFlag = false;

            for (int j = 2; j < i; j++){
                if (i % j == 0){
                    isFlag = true;
                    break;//优化一：跳出循环，节省时间，只对非质数的自然数有效
                }

            }
            if (isFlag == false){
                count2++;
            }
        }
        System.out.println();
        long end2 = System.currentTimeMillis();
        System.out.println(count2);
        System.out.println(end2 - start2);


        //输出质数，优化2
        int count3 = 0;
        long start3 = System.currentTimeMillis();
        for(int i = 2; i<100000; i++){

            boolean isFlag = false;

            for (int j = 2; j <= Math.sqrt(i); j++){//优化2：改为开方，对本身是质数的自然数有效
                if (i % j == 0){
                    isFlag = true;
                    break;//优化一：结束当前循环，节省时间，只对非质数的自然数有效
                }

            }
            if (isFlag == false){
                count3++;
            }


        }
        System.out.println();
        long end3 = System.currentTimeMillis();
        System.out.println(count3);
        System.out.println(end3 - start3);

        //质数的另一种输出方法
        int count4 = 0;
        long start4 = System.currentTimeMillis();
        label: for (int i = 2; i <= 100000; i++){
            for (int j = 2; j <= Math.sqrt(i); j++){
                if (i % j == 0){
                    continue label;
                }
            }
            count4++;
        }
        long end4 = System.currentTimeMillis();
        System.out.println(count4);
        System.out.println(end4 - start4);

         */

        /*
        //cpntinue关键字与break关键字：结束当次循环与当前循环
        for(int i = 1; i <= 10; i++){
            if (i % 4 == 0){
                break;
            }else {
                System.out.print(i);
            }
        }

        System.out.println();

        for(int i = 1; i <= 10; i++){
            if (i % 4 == 0){
                continue;
            }else {
                System.out.print(i);
            }
        }

        System.out.println();

        label:for (int i = 1; i <= 4; i++){
            for (int j = 1; j <= 10; j++){
                if (j % 4 == 0){
                   break label;//结束指定标识层的一层循环
                    // contiune label; //结束指定标识符的一层循环结构的当次循环
                }
            }

            System.out.print(i);
        }

         */

        //一个数字如果恰好等于它的因子之和，这个数就称为完数，例如：6=1+2+3
        //找出1000以内的所有完数
        long start5 = System.currentTimeMillis();
        for (int i = 1; i <=1000; i++){
            int sum = 0;

            for (int j = 1; j <= i/2; j++){
                if (i % j == 0){
                    sum += j;

                }
            }
            if (sum == i){
                System.out.println(i);
            }

        }
        long end5 = System.currentTimeMillis();
        System.out.println(end5-start5);



    }

}
