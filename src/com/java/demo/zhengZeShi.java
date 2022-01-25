package com.java.demo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zhengZeShi {
    public static void main( String args[]){
        //指定模式在字符串查找
        String line = "this order was placed for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";

        //创建pattern对象
        Pattern r = Pattern.compile(pattern);

        //创建match对象
        Matcher m = r.matcher(line);
        if(m.find()){
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        }else {
            System.out.println("NO MATCH");
        }
    }
}
