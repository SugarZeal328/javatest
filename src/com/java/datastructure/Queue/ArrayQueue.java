package com.java.datastructure.Queue;

import java.util.Arrays;
import java.util.Scanner;

/*
使用数组模拟队列
 */
public class ArrayQueue {

    int maxsize;//数组最大容量
    int front;//指向队列头之前一个
    int rear;//指向队列尾

    int[] arrQueue;//队列数组

    public ArrayQueue(){

    }

    public ArrayQueue(int maxsize){
        this.maxsize = maxsize;
        arrQueue = new int[maxsize];
    }

    {
        front = -1;
        rear = -1;
    }

    //判断队列是否为满
    public boolean isFull(){

        if (rear == maxsize -1) return true;
        return false;

    }

    //判断队列是否为空
    public boolean isEmpty(){
        if (rear == front) return true;
        return false;
    }

    //给队列添加数据，尾指针后移
    public void addQueue(int n){
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        arrQueue[++rear] = n;

    }

    //取出队列数据
    public int getQueue(){
        if (isEmpty()){
            //通过抛出异常结束
            throw new RuntimeException("Queue is empty!");
        }

        System.out.println(arrQueue[front + 1]);
        return arrQueue[++front];
    }

    //显示队列所有数据
    public void show(){
        System.out.println(Arrays.toString(arrQueue));
    }

    //遍历队列所有数据
    public void list(){
        if (isEmpty()) throw new RuntimeException("Queue is empty!");

        for (int i = front + 1; i < rear + 1; i++){
            System.out.print("arrQueue[" + i + "] = " + arrQueue[i] + " ");
        }
        System.out.println();
    }

    //显示头数据，非取出
    public int headQueue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty!");
        System.out.println(arrQueue[front + 1]);
        return this.arrQueue[front + 1];
    }
}

class ArrayQueueTest{

    public static void main(String[] args){

        ArrayQueue aq1 = new ArrayQueue(3);

        Scanner sc = new Scanner(System.in);

        //接收用户输入
        char key = ' ';

        //
        boolean flag = true;

        //定义一个菜单
        while (flag){
            System.out.println("s(show): 显示所有数列数据");
            System.out.println("a(add): 添加队列");
            System.out.println("g(get): 取出队列数据");
            System.out.println("l(list): 遍历当前队列");
            System.out.println("h(head): 显示对队列头部");
            System.out.println("e(exit): 退出");

            key = sc.next().charAt(0);//接收一个字符

            switch (key){
                case 's':
                    aq1.show();
                    break;

                case 'a':
                    System.out.println("请输入要添加的数字");
                    int num = sc.nextInt();
                    aq1.addQueue(num);
                    break;

                case 'g':
                    aq1.getQueue();
                    break;

                case 'l':
                    aq1.list();
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
