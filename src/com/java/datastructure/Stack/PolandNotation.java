package com.java.datastructure.Stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //定义一个逆波兰表达式(3+4)*5-6
        //为了方便，数字和符号使用空格隔开
        String suffixExpression = "4 2 + 5 - 2 2 * +";
        //1.将"3 4 + 5 * 6 -"放入ArrayList中
        //2.将ArrayList传给一个方法，进行遍历并完成计算
        int i = PolandNotation.calculate(PolandNotation.getListString(suffixExpression));
        System.out.println(i);

    }

    public static List<String> getListString(String suffixExpression){
        //将传入的字符串分割
        String[] split = suffixExpression.split(" ");
        //使用list，避免了辅助使用辅助指针对字符串进行subString
        List<String> list = new ArrayList<>();

        for (String str : split) {
            list.add(str);
        }

        return list;
    }

    public static int calculate(List<String> ls) {
        //创建栈
        Stack<String> stack = new Stack<>();
        for (String str : ls) {
            //使用正则表达式来匹配
            if (str.matches("\\d+")) {//匹配字
                //push
                stack.push(str);
            } else {
                //pop 出两个数，进行运算，然后再入栈
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                //判断运算符
                switch (str) {
                    case "+":
                        res = num2 + num1;
                        break;

                    case "-":
                        res = num2 - num1;//顺序问题，stack是先进后出，num2是后出的数，因此在运算符前
                        break;

                    case "*":
                        res = num2 * num1;
                        break;

                    case "/":
                        res = num2 / num1;
                        break;
                }
                stack.push(String.valueOf(res));
            }
        }
        System.out.println(stack.peek());
        return Integer.parseInt(stack.pop());

    }
}

