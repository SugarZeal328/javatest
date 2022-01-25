package com.java.exercise.CommonlyClass;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableTest {
    @Test
    public void test() {
        Goods[] goods = new Goods[4];

        goods[0] = new Goods(1,"a");
        goods[1] = new Goods(3,"b");
        goods[2] = new Goods(3,"c");
        goods[3] = new Goods(4,"d");

        Arrays.sort(goods);

        System.out.println(Arrays.toString(goods));

        /*
        Comparator接口的使用：定制排序
        1.当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码
        或者实现了了java.lang.Comparable接口的排序规则不适合当前的操作。
        那么可以考虑使用Comparator的对象来排序
        */
        //在sort中重写Comparator的copare方法实现价格从高到低排列
        Arrays.sort(goods, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                return -Double.compare(o1.getPrice(), o2.getPrice());
            }
        });

        System.out.println(Arrays.toString(goods));
    }
}

class Goods implements Comparable{

    private double price;
    private String name;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Goods(double price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        System.out.println("zzzzzzzzzzzzzzz");
        if (o instanceof Goods){
            Goods goods = (Goods) o;
            //方式一
            if (this.price > goods.price){
                return 1;
            }else if (this.price < goods.price) {
                return -1;
            }else if (this.price == goods.price){
                return this.name.compareTo(goods.name);
            }
            //方式2：Double.compare(this.price, goods.price)
        }
        throw new RuntimeException("传入的数据类型错误");
    }

    @Override
    public String toString() {
        return "Goods{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
