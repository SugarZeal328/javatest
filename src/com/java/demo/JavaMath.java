package com.java.demo;

public class JavaMath {
    public static void main (String []args){
        /*
        System.out.println("sin90 = " + Math.sin(Math.PI/2));
        System.out.println("1的反正切值是" + Math.atan(1));
        System.out.println("PI的角度值是" + Math.toDegrees(Math.PI));
        System.out.println(Math.PI);
         */

        /*
        char ch1 = 'a';
        char[] charArray = {'a', 'b', 's', 't', 'r', 'a', 'c', 't'};
        Character ch2 = new Character('a');
        String str2 = "concrete";
        String str3 = new String(charArray);
        //包装类charArray输出的为内存地址，实例化对象str3输出的为值
        //String 类是不可改变的，所以你一旦创建了 String 对象，那它的值就无法改变了。
        // 如果需要对字符串做很多修改，那么应该选择使用 StringBuffer & StringBuilder 类。
        System.out.println(ch1 + "\n" + ch2 +"\n" + charArray + "\n" +str3);
        //输出字符串长度
        System.out.println(str3.length());
        //连接字符串的几种方法
        System.out.println(str2.concat(str3) + "\n" + "concrete".concat(str3));
         */
        float floatVar = 12;
        int intVar = 3;
        String stringVar = "长亭外，古道别，芳草碧连天";
        System.out.printf("The value of the float variable is " +
                "%f, while the value of the integer " +
                "variable is %d, and the string " +
                "is %s", floatVar, intVar, stringVar);
    }
}
