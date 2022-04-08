package com.java.datastructure.Stack;

import com.java.datastructure.LinkedList.SingleLinkedList.HeroNode;
import org.junit.Test;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.Scanner;

public class StackDemo {
    @Test
    public void test1() {
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 表示显示stack");
            System.out.println("exit: 表示退出");
            System.out.println("push: 添加数据到stack");
            System.out.println("pop: 从stack取出数据");
            System.out.println("input command: ");
            key = scanner.next();
            switch (key) {
                case "show":
                    arrayStack.listStacck();
                    break;

                case "exit":
                    scanner.close();//避免资源泄漏
                    loop = false;
                    break;

                case "push":
                    System.out.println("请输入一个数");
                    int value;
                    value = scanner.nextInt();
                    arrayStack.push(value);
                    break;

                case "pop":
                    try {
                        System.out.println(arrayStack.pop());
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }

        }

        System.out.println("已退出");


    }

    @Test
    public void test2() {
        ListStack listStack = new ListStack();
        listStack.push(new HeroNode(2,"卢俊义", "玉麒麟"));
        listStack.push(new HeroNode(4,"我的饭", "我的饭"));
        listStack.push(new HeroNode(5,"我的", "我的"));
        listStack.list();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
        listStack.pop();
        listStack.list();



    }

}

//定义一个由数组模拟的stack
class ArrayStack {
    private int maxTop; //stack size
    private int[] stack;//模拟stack的数组
    private int top = -1;//top 表示stack top，初试化为-1

    public ArrayStack(int maxTop) {
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
}

class ListStack {
    private HeroNode head = new HeroNode(0, "", "");
    private HeroNode tail;
    private int top = -1;

    public void push(HeroNode heroNode) {
        if (top == -1) {
            head.next = heroNode;
            tail = heroNode;
            top++;
        } else {
            HeroNode temp = head.next;
            head.next = heroNode;
            heroNode.next = temp;
            top++;
        }

    }

    public void pop() {
        if (top == -1) {
            throw new RuntimeException("listStack is null");
        } else {
            HeroNode temp = head.next.next;
            head.next = temp;
            top--;

        }
    }

    public void list() {
        HeroNode temp = head.next;
        for (int i = 0; i <= top; i++) {
            System.out.println(temp);
            temp = temp.next;
        }


    }
}