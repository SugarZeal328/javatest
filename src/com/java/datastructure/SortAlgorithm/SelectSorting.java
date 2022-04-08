package com.java.datastructure.SortAlgorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectSorting {

    public static void main(String[] args) {
        int[] arr = new int[80000];

        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*80000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss:ms");
        String str1 = simpleDateFormat.format(date1);
        System.out.println(str1);

        select(arr);

        Date date2 = new Date();
        String str2 = simpleDateFormat.format(date2);
        System.out.println(str2);
    }

    public static void select(int[] arr) {
        int temp = 0;
        //循环n-1次，最后一位不用查找
        for (int i = arr.length-1; i > 0; i--){
            //假定当前位置的数是最小数
            int mini = arr[arr.length -1- i];
            boolean flag = false;
            //System.out.println(mini);
            for (int j = arr.length-i ; j < arr.length; j++){
                if (arr[j]  < mini) {
                    mini = arr[j];
                    temp = j;
                    flag = true; //如果有修改，则必须更改信标，进入值的互换
                }
            }if (flag) {
                arr[temp] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = mini;
            }
        }
    }
}
