package com.java.datastructure.Stack;

import java.util.*;

public class NIPolandCalculator {
    public static void main(String[] args) {
        String suffixExpression = "((4+2)*2)-2*6";
        System.out.println(NIPolandCalculator.toInfixExpressionList(suffixExpression));
        System.out.println(parseSuffixExpression(toInfixExpressionList(suffixExpression)));
        calculate(parseSuffixExpression(toInfixExpressionList(suffixExpression)));



    }

    //将中缀表达式转为list
    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<>();
        int i = 0; //index 用于遍历中缀字符串
        String str; //多位数的拼接工作
        char c;
        do {
            //如果c为非数字，则加入ls
            if((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57 ){
                ls.add(String.valueOf(c));
                i++;
            } else {//是数字，则判断多位数
                str="";
                while (i < s.length() &&(c=s.charAt(i)) >= 48 && (c=s.charAt(i)) <= 57){
                    str += c;//拼接
                    i++;
                }
                ls.add(str);
            }

        }while (i < s.length());

        return ls;
    }

    //转为逆波兰
    public static List<String> parseSuffixExpression(List<String> ls) {
        Stack<String> s1 = new Stack<>();//运算符栈
        Stack<String> s2 = new Stack<>();//中间结果保存栈

        for (String s : ls) {
            if (isOper(s)){
                switch (s){
                    case "(":
                        s1.push(s);
                        break;

                    case ")":
                        while (true){
                            String str = s1.pop();
                            if (!str.equals("(")) s2.push(str);
                            else break;
                        }
                        break;

                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        if (s1.isEmpty()) {
                            s1.push(s);
                        } else if (priority(s) > priority(s1.peek())){
                            s1.push(s);
                        }
                        else {
                            while (true){
                                if (!s1.isEmpty()){
                                if (priority(s) <= priority(s1.peek())) {
                                    s2.push(s1.pop());
                                }
                                }else break;
                            }s1.push(s);
                        }

                }
            } else s2.push(s);
        }

        //System.out.println(s1);
        //System.out.println(s2);

        //遍历结束后，将S1中剩余的运算符压入S2
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }

        List<String> list = new ArrayList<>();

        while (!s2.isEmpty()){
            list.add(s2.pop());
        }
        Collections.reverse(list);
        return list;
    }

    public static int calculate(List<String> ls) {
        //逆波兰计算器在于入栈时进行判断，如果时运算符就取出栈顶元素 运算，是数字则入栈
        //创建栈
        Stack<String> stack = new Stack<>();
        for (String str : ls) {
            //使用正则表达式来匹配
            if (!isOper(str)) {//匹配字
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

    //返回运算符的优先级
    public static int priority(String oper) {
        if (oper.equals("*") || oper.equals("/")) return 1;
        if (oper.equals("+") || oper.equals("-")) return 0;
        else return -1;
    }

    //判断是否为运算符
    public static boolean isOper(String val) {
        if (val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/") || val.equals("(") || val.equals(")")){
            return true;
        }else return false;
    }


}
