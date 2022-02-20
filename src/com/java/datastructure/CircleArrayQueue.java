package com.java.datastructure;

import java.util.Scanner;

public class CircleArrayQueue {

    private int maxSize;//数组最大容量
    private int front;//指向队列第一个元素，初始值为0
    private int rear;//指向队列尾最后一个元素的后一个位置，初始值为0

    int[] circleArrQueue;//队列数组

    public CircleArrayQueue(){

    }

    public CircleArrayQueue(int maxSize){
        this.maxSize = maxSize;
        circleArrQueue = new int[maxSize];
    }

    {
        front = 0;
        rear = 0;
    }

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public void addQueue(int num){
        if (isFull()) throw new RuntimeException("the Queue is full\n");
        circleArrQueue[rear] = num;
        //将rear后移，此时必须考虑对rear取模，防止溢出
        rear = (rear + 1)%maxSize;
    }

    public int getQueue(){
        if (isEmpty()) throw new RuntimeException("the Queue is empty\n");
        int tempIndex = front;
        //取模防止溢出
        front = (front + 1)%maxSize;
        return circleArrQueue[tempIndex];
    }

    public void listQueue(){
        if (isEmpty()) throw new RuntimeException("the Queue is empty\n");
        for(int i = front; i < front + size(); i++){
            System.out.println("circleArrQueue[" + i + "] = " + circleArrQueue[i % maxSize] + " ");
            System.out.println();
        }
    }

    public int size(){
        //获取当前元素个数
        return (rear + maxSize -front)%maxSize;
    }

    public int headQueue(){
        if (isEmpty()) throw new RuntimeException("the Queue is empty\n");
        return circleArrQueue[front];
    }
}

class CircleArrQueueTest{

    public static void main(String[] args){

        //数组模拟环形队列最后一个位置需空出为rear+1 的约定预留位
        CircleArrayQueue aq1 = new CircleArrayQueue(3);

        Scanner sc = new Scanner(System.in);

        //接收用户输入
        char key = ' ';

        //
        boolean flag = true;

        //定义一个菜单
        while (flag){

            System.out.println("a(add): 添加队列");
            System.out.println("g(get): 取出队列数据");
            System.out.println("l(list): 遍历当前队列");
            System.out.println("h(head): 显示对队列头部");
            System.out.println("e(exit): 退出");
            System.out.print("请输入字符：");

            key = sc.next().charAt(0);//接收一个字符

            switch (key){

                case 'a':
                    System.out.println("请输入要添加的数字");
                    int num = sc.nextInt();
                    aq1.addQueue(num);
                    break;

                case 'g':
                    aq1.getQueue();
                    break;

                case 'l':
                    aq1.listQueue();
                    break;

                case 'h':
                    aq1.headQueue();
                    break;

                case 'e':
                    flag = false;
                    break;

                default:
                    break;
            }
        }


    }
}
