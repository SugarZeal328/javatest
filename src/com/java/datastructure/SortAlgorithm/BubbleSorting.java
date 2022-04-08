package com.java.datastructure.SortAlgorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSorting {

    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*80000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss:ms");
        String str1 = simpleDateFormat.format(date1);
        System.out.println(str1);

        bubble(arr);

        Date date2 = new Date();
        String str2 = simpleDateFormat.format(date2);
        System.out.println(str2);

    }

    public static void bubble(int[] arr) {


        for (int i = 0; i < arr.length - 1; i++){
            boolean flag = false;
            int temp = 0;
            for (int j = 0; j < arr.length-1-i; j++){
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }

            if (flag == false) return;
        }
    }
}
