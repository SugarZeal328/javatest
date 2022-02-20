package com.java.javaBase;

import java.util.BitSet;

public class BoyGirlTest {

    public static void main(String[] args){
        Girl g1 = new Girl("lucy", 23);
        Girl g2 = new Girl("lily", 24);
        Boy b1 = new Boy("tom", 24);
        g1.marry(b1);
        System.out.println(g1.compare(g2));
    }
}
