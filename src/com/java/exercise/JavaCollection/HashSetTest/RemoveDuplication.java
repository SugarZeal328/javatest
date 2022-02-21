package com.java.exercise.JavaCollection.HashSetTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/*
通过hashset去除list中的重复值
 */
public class RemoveDuplication {

    @Test
    public void test1() {
        List list = new ArrayList();

        list.add(new Integer(1));
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(3));

        HashSet hashSet = new HashSet<>();
        hashSet.addAll(list);

        List list1 = new ArrayList();
        list1.addAll(hashSet);

        Iterator iterator = list1.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
