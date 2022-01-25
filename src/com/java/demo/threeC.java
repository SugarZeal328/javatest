package com.java.demo;

import org.omg.CORBA.PUBLIC_MEMBER;
import java.util.Scanner;
public class threeC {
    public static void main(String[] args){
        //三元运算，效率和switch-case一样
        /*int x = 10;
        int y =5;
        int z  = (x > y)?x:y;
        System.out.print(z);

         */
        Scanner scan = new Scanner(System.in);
        /*

        //从键盘接手数据
        System.out.println("next方式接收字符串");
        String str2 = scan.nextLine();
        String str3 = scan.next();
        System.out.println("nextLine()可得到带空格的字符" + str2);
        System.out.println("nex()无法得到带空格的字符" + str3);
        scan.close();

         */
        //判断是否有输入
        /*if(scan.hasNext()){
            String str1 = scan.next();
            System.out.println("输入的数据为:" + str1);
        }
        scan.close();

         */
        //对于int或者float类型的数据，在输入前最好使用hasnextXxx()方法进行验证，使用nextXxx()输出
        int i = 0;
        float f = 0.0f;
        System.out.println("输入整数:");
        //从键盘接收数据
        if (scan.hasNextInt()){
            //判断是否为整数
            i = scan.nextInt();
            //接收整数
            System.out.println("整数的数据：" + i);
        } else {
            System.out.println("输入的不是整数");
        }
        System.out.println("输入小数");
        if (scan.hasNextFloat()){
            f = scan.nextFloat();
            System.out.println("小数的数据:" + f);
        } else {
            System.out.println("输入的不是小数");
        }
        scan.close();
    }
}
