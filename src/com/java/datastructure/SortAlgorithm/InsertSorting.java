package com.java.datastructure.SortAlgorithm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSorting {
    public static void main(String[] args) {
        int arr1[] = new int[]{4, 2, -10, 100, 45, 98, 18};
        /*
        insert(arr);
        for (int i: arr1){
            System.out.print(i + ", ");
        }

         */
        int[] arr = new int[80000];

        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*80000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss:ms");
        String str1 = simpleDateFormat.format(date1);
        System.out.println(str1);

        insert(arr);
        for (int i = 0; i < 101; i++){
            System.out.print(arr[i] + ",");
        }
        System.out.println();

        Date date2 = new Date();
        String str2 = simpleDateFormat.format(date2);
        System.out.println(str2);

    }

    public static void insert(int[] arr){
        int val = 0;
        int index = 0;
        for (int i = arr.length-1; i > -1; i--){
            val = arr[i];
            index = i + 1;
            while (index <= arr.length-1 && arr[index] < val){
                //比当前值小的往前移动一位
                arr[index-1] = arr[index];
                //指针继续走，直到找到合适的位置
                index++;
            }
            if (index - 1 != i) {
                arr[index - 1] = val;
            }
        }
    }
}
