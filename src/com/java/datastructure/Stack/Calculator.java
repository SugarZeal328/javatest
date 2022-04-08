package com.java.datastructure.Stack;

import javax.security.auth.login.AccountExpiredException;

public class Calculator {

    public static void main(String[] args) {
        String expression = "100*2-50/5";
        //创建两个stack，一个存放数字，一个存放运算符
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要的相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";

        while (true){
            //得到expression中的每一个字符
            ch = expression.substring(index, index+1).charAt(0);
            //判断是否为符号
            if (operStack.isOper(ch)) {
                //判断当前符号stack是否为空
                if (operStack.isEmpty()){
                    //为空则直接压入符号
                    operStack.push(ch);

                }else {
                    //传入的运算符优先级低于栈顶中运算符的优先级，则先对栈顶中运算符进行运算，然后将结果传回栈中
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        numStack.push(numStack.cal(num1,num2,oper));//优先级高的运算结果进数栈
                        operStack.push(ch);//当前操作符进操作符栈
                    }else {
                        //传入的运算符优先级高于栈顶中运算符的优先级，直接入栈
                        operStack.push(ch);

                    }
                }

            }else {
                //如果是数字，则直接入栈
                /*
                这是一个很简单的数值类型转换，所使用到的知识是ASCII码。char型数字0-9在ASCII码中是在48-58的位置上，
                所以char转换为int时减去的字符’0’其实就是char型数字的ASCII码值减去了48。
                但对于多位数，此方法不可用，需要进行拼接
                 */
                //numStack.push(ch - 48);
                keepNum += ch;
                //如果ch已经是expression 的最后一位，则直接入栈
                if (index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }
                //扫描下一位是否仍是数字，是则继续扫描，是运算符则入栈
                else if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
                    //后一位是运算符，则入栈
                    numStack.push(Integer.parseInt(keepNum));
                    //重置keepNum
                    keepNum = "";
                }


            }
            //让index+1，并判断是否扫描到结尾
            index++;
            if (index == expression.length()) break;
        }

        //当扫描完毕后，就顺序从数栈和运算符栈中pop出相应的数据运算
        while (true) {
            if (operStack.isEmpty()) break;
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            numStack.push(operStack.cal(num1,num2,oper));
        }

        System.out.println(numStack.pop());
    }
}

class ArrayStack2 {
    private int maxTop; //stack size
    private int[] stack;//模拟stack的数组
    private int top = -1;//top 表示stack top，初试化为-1

    public ArrayStack2(int maxTop) {
        this.maxTop = maxTop;
        stack = new int[maxTop];
    }

    //stack full
    public Boolean isFull() {
        return top == maxTop;
    }

    //stack empty
    public Boolean isEmpty() {
        return top == -1;
    }

    //push
    public void push(int value) {
        if (isFull()) {
            System.out.println("stack is full");
        } else {
            top++;
            stack[top] = value;
        }
    }

    //pop，将top数据返回
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        } else {
            int value = stack[top];
            top--;
            return value;
        }
    }

    //从stack top开始
    public void listStacck() {
        for (int i = top; i > -1; i--) {
            int value = stack[i];
            System.out.println(value);
        }
    }

    //获取stack top ，同时不出stack
    public int peek() {
        return stack[top];
    }

    //返回运算符的优先级
    public int priority(int oper) {
        if (oper == '*' || oper == '/') return 1;
        if (oper == '+' || oper == '-') return 0;
        else return -1;
    }

    //判断是否为运算符
    public boolean isOper(char val) {
        return val== '*' || val == '/' || val == '+' || val == '-';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num2 + num1;
                break;

            case '-':
                res = num2 - num1;//顺序问题，stack是先进后出，num2是后出的数，因此在运算符前
                break;

            case '*':
                res = num2 * num1;
                break;

            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }

}