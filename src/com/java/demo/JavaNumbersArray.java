package com.java.demo;
import java.math.*;

public class JavaNumbersArray {
    public static void main (String []args){
        /*
        //声明数组变量的方法
        //dataType[] arrayRefVar & dataType arrayRefVar[]
        //两种方法效果一样，但前者是首选
        int[] array1 = new int[3];
        int array2[] = new int[3];
        for(int x = 0; x < array1.length; x++){
            array1[x] = x;
            System.out.print(array1[x]);
        }

        System.out.println();

        //分布模式开启数组
        int[] array3 = null;
        array3 = new int[3];
        array3 = array1;
        for(int x = 0; x<array3.length; x++){
            System.out.print(array3[x]);
        }
         */
        //数组属于引用数据类型，使用数组前一定要实例化

        //处理数组
        double[] mylist = {1.9, 2.9, 3.8, 3.4};
        double total = 0;
        double max = mylist[0];
        for (int i = 0; i < mylist.length; i++){
            System.out.print(mylist[i] + " ");//print array
            total += mylist[i];//sum element
            if(mylist[i] > max){
                max = mylist[i];
            }//max value
        }
        System.out.println();
        System.out.println("array total is " + total);
        System.out.println("max value is " + max);

        //foreach循环，可在不适用下标的情况下遍历整个数组
        for (double element: mylist){
            System.out.println(element);
        }
    }
}
