package com.java.exercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class JUnitEqualTestTest {

    @Test
    public void testEquals() {
        EqualTest t1 = new EqualTest(1);
        EqualTest t2 = new EqualTest(1);
        String str1 = new String("zzz");
        String str2 = new String("zzz");
        System.out.println(str1.equals(str2));
    }
}