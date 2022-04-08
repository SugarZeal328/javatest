package com.java.datastructure.Recursion;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queue8 {
    //放置方法计数
    static int count;
    //定义8个皇后
    static int max = 4;
    //定义数组array，保存皇后放置位置的结果
    static int[] array = new int[max];
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        check(0);
        System.out.println(count);



    }

    //将皇后摆放的位置打印
    private static void queueLocation() {
        System.out.print("[");
        for (int i : array){
            System.out.print(i + ", ");
        }
        System.out.print("]");
        System.out.println();
    }

    //查看当我们放置第N个皇后时，检测与前面的皇后是否冲突

    /**
     *
     * @param n 第n个🫅
     * @return
     */
    private static boolean judge(int n) {
        for (int i = 0; i < n; i++){
            //array[i] == array[n] 判断是否在同一列
            //Math.abs(n-i) == Math.abs(array[n] = array[i]) 判断是否在同一个对角线上(通过计算斜率表示，正方形对角线斜率为1，只要
            // |行-行| = |列-列|,即表明这两点在斜率绝对值为1的直线上，数组的下标i为横坐标，array[i]为纵坐标
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])) return false;
        }
        return true;
    }

    private static void check(int n) {
        //从0开始，n=8时，已经全部放置完毕，则直接打印结束
        if (n == array.length) {queueLocation();  count = count+1; return;}

        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < array.length; i++) {
            //先把当前皇后放置在该行的第一列
            array[n] = i;
            //判断放置在此处是否冲突，如果冲突则继续执行array[n] = i+1
            //此时是会有回溯，因为check调用judge方法，会判断若第i个节点放置在此处时，往下继续是否能够完成一个正确的组合
            if (judge(n)) {check(n+1);}
        }
    }



}
