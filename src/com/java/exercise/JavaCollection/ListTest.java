package com.java.exercise.JavaCollection;

import org.junit.Test;

import java.util.*;

/*collection接口：单列数据，定义了存取一组对象方法的集合
list：元素有序、可重复的集合，动态数组：arraylist(主要实现类), linkedlist, vector(古老实现类)
set：元素无序，不可重复的集合，集合，无序，确定性，互异性: hashset, linkedhashset, treeset

1.arraylist, linkedlist, vector三种异同
同：都实现了list接口，存储的数据是有序的，可重复的数据
区：ArrayList: 线程不安全，效率高，底层使用Object[]，默认创建一个长度为10的数组，添加数据后，容量默扩容为原来的1.5倍。
同时会对原有数组中的数据进行复制（建议开发中使用带参的构造器ArrayList list  = new ArrayList(int capacity)）
jdk8中。对于空参构造的ArrayList并不会默认提供存储空间，只有当add操作时，才会提供，懒汉式，节省内存

vector：线程安全，效率低，底层使用Object[],使用vector()作为构造器，底层长度也为10，默认扩容为原有数组长度的2倍

LinkedList：底层使用双向链表存储，对于频繁的插入、删除操作，使用此类效率较高，但LinkedList没有索引
node<prev, value, next>
 */
public class ListTest {

    @Test
    public void test1() {
        ArrayList list1  = new ArrayList(10);
        //void add(int index, Object obj)
        list1.add(0,"AA");

        //boolean addAll()
        List list2 = Arrays.asList(1,2,3);
        list1.addAll(list2);

        //get(int index)
        System.out.println(list1.get(2));

        //int indexOf(Object obj) 返回obj第一次出现的所在位置的索引值，未找到输出-1
        //int lastIndexOf(Object obj) 返回obj最后一次出现的所在位置的索引值，未找到输出-1
        System.out.println(list1.indexOf("AA"));

        //Object remove(int index) 返回删除的元素
        //Object remove(Object obj)

        //Object set(int index, Object obj) 设置制定index位置上的元素值
        list1.set(1,"BB");

        //list subList(int fromIndex, int toIndex) 子集合，左闭右开
        List sublist = list1.subList(0,2);
        System.out.println(sublist);

        Iterator iterator = list1.iterator();
        //遍历方式1：
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("***************************");

        //遍历方式2：
        for (Object obj  : list1){
            System.out.println(obj.toString());
        }

    }

    //面试题
    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);

    }

    public void updateList(List list) {
        //删除元素请用包装类
        list.remove(2);//移除索引为2的元素
        //list.remove(new Integer(2));//移除值为2的元素
    }


}
