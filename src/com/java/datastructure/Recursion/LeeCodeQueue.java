package com.java.datastructure.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeeCodeQueue {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));;

    }
}

class Solution {
    int count;
    List<List<String>> list = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        check(0,createArray(n));
        return list;

    }

    public boolean judge(int n, int[] array) {
        for(int i=0; i<n; i++){
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])) return false;
        }
        return true;
    }

    public  int[] createArray(int n){
        int a[] = new int[n];
        return a;
    }

    public void check(int n, int[] a){
        if(n == a.length) {list.add(getList(a)); count++; return;}
        for(int i = 0; i < a.length; i++){
            a[n] = i;
            if(judge(n,a)){
                check(n+1, a);
            }
        }
    }

    public List<String> getList(int[] a){
        List<String> list = new ArrayList<>();
        for(int i : a){
            StringBuffer str = new StringBuffer();
            for(int j = 0; j<a.length; j++){
                if(i == j) str.append("Q");
                else str.append(".");
            }
            list.add(str.toString());
        }
        return list;
    }
}


