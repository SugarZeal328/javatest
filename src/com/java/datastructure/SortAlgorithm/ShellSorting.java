package com.java.datastructure.SortAlgorithm;

import java.time.chrono.MinguoDate;

public class ShellSorting {

    public static void main(String[] args) {
        int arr1[] = new int[]{4, 2, -10, 100, 45, 98, 18, 10, -99, -101};

        shell(arr1);
        for (int i: arr1){
            System.out.print(i + ", ");
        }
    }

    public static void shell(int[] arr) {
        int gap = (arr.length) / 2;
        int temp = 0;
        while (gap > 0) {

            for (int i = gap; i < arr.length; i++){
                //插入算法的写法，假设1个有序，n-1个无序，倒着写
                for (int j = i -gap; j >= 0; j -= gap){
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            gap = gap/2;
        }
    }

    public static void shell1 (int[] arr){
        int temp = 0;
        for (int gap = arr.length/2; gap > 0; gap = gap/2){
            for (int i = gap; i < arr.length; i++){
                //插入算法的写法，假设1个有序，n-1个无序，倒着写
                for (int j = i -gap; j >= 0; j -= gap){
                    if (arr[j] > arr[j + gap]) {
                         temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }
}
