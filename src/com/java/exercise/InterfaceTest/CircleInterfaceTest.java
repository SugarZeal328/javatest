package com.java.exercise.InterfaceTest;

import org.junit.Test;

public class CircleInterfaceTest {
    @Test
    public void test() {

        CompareObject cc1 = new ComparableCircle(1.0);
        CompareObject cc2 = new ComparableCircle(2.0);

        System.out.println(cc1.compareTo(cc2));

    }
}

interface CompareObject {
    //半径比较
    // 返回值0：相等 正数：当前对象大 负数：当前对象小
    double compareTo(Object o);
}

class Circle {
    private double redius;//半径

    public Circle() {
    }

    public Circle(double redius) {
        this.redius = redius;
    }

    public double getRedius() {
        return redius;
    }

    public void setRedius(double redius) {
        this.redius = redius;
    }
}

class ComparableCircle extends Circle implements CompareObject {


    public ComparableCircle() {
    }

    public ComparableCircle(double redius) {
        super(redius);
    }

    @Override
    public double compareTo(Object o) {
        if (o == this) return 0;
        if (o instanceof Circle){
            Circle o1 = (Circle) o;
            return this.getRedius() - o1.getRedius();
        }else throw new RuntimeException("传入数据对象不匹配");
    }
}


