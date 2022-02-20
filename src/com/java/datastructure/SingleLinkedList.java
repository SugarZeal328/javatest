package com.java.datastructure;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import sun.reflect.misc.ReflectUtil;

import java.util.Stack;

/*
添加节点单向链表
不考虑编号顺序
思路
1.找到当前节点的最后节点
2.
 */
public class SingleLinkedList {

    public static void main(String[] args){

        SingleLinkedListManage llm = new SingleLinkedListManage();
        SingleLinkedListManage llm1 = new SingleLinkedListManage();

        HeroNode heroNode1 = new HeroNode(1,"宋江","呼保义");

        llm.addByOrder(heroNode1);
        llm.addByOrder(new HeroNode(3,"吴用", "智多星"));

        llm1.addByOrder(new HeroNode(2,"卢俊义", "玉麒麟"));


        llm.mergeSingleLinkedList(llm, llm1);


        System.out.println();


    }



}

//每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;//指向下一个节点

    public HeroNode(){

    }

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

class SingleLinkedListManage {
    //初始化头节点；
    private final HeroNode head = new HeroNode(0,"","");//头节点
    private int tailIndex;//尾节点指针
    //添加节点到单向链表
    //思路：不考虑编号的顺序时：1.找到当前节点的最后节点。 2.将最后节点的next指向新的节点
    public void add(HeroNode heroNode) {

        //头节点不可动，因此需要一个辅助遍历节点
        HeroNode temp = head;
        //遍历链表
        while (true) {
            if (temp.next == null) break;
            temp = temp.next;
        }
        //循环结束后，temp就指向了最后的节点
        temp.next = heroNode;

    }

    //按给定的顺序插入节点
    public void addByOrder(HeroNode heroNode){
        //头节点不可动，通过辅助指针帮助我们遍历节点
        //因为是单链表，temp是要插入节点的前一个节点，用于插入
        HeroNode temp = head;
        boolean flag = false;//判断添加的节点是否存在
        while (true){
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            }
            if (temp.next.no > heroNode.no){
                //此时找到了heroNode应在的位置
                heroNode.next = temp.next;
                temp.next = heroNode;
                break;
           }else if (temp.next.no == heroNode.no){

                throw new RuntimeException("链表中的该编号已存在");
            }

            temp = temp.next;
        }


    }

    //按no号更新
    public void updateByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;

        while (true){
            if (temp == null) {
                System.out.println("链表已遍历完");
                break;
            }
            if (temp.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }else System.out.printf("未找到编号%d的节点\n", heroNode.no);

    }

    public void del(int no){

        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                System.out.printf("已遍历完，未找到no.%d节点",no);
                break;
            }
            if (temp.next.no == no){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    //遍历数组
    public void list() {
        //先判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //利用辅助变量遍历
        HeroNode temp = head.next;
        while (true){
            //判断是否到最后
            if (temp == null) break;
            System.out.print(temp.toString() + " \n");
            temp = temp.next;
        }
    }

    //求链表中有效节点个数(不包含头节点)
    public int getLength(){
        if (this.head == null){
            System.out.println("头节点为空");
            return 0;
        }

        int length = 0;
        HeroNode temp = head.next;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        return length;


    }

    //查找单链表中倒数第K个节点的位置
    public HeroNode getBottomNoNode(int k){
        int length = this.getLength();
        int j;
        HeroNode temp = this.getHead();

        if (k < 0 || length < k){
            System.out.println("K值越界");
            return null;
        }else j = length - k;
        for (int i = 0; i <= j; i++){
            temp = temp.next;
        }
        return temp;

    }

    //查找倒数第K个元素，只遍历一次
    public HeroNode getBottomNodeByOnce(int k){
        HeroNode temp1 = this.head;
        HeroNode temp2 = this.head;

        int count = 0;
        if (k <= 0){
            System.out.println("K值越界！");
            return null;
        }
        //先让第一个指针先走K步
        while (count < k ){
            temp1 = temp1.next;
            count++;
        }

        //第二个指针开始移动，两个指针间差值为K-1
        if (temp1 == null) System.out.println("K值越界！");
        while (temp1 != null){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp2;

    }

    //反转链表
    /*
    1.定义一个节点reverseHead = new HeroNode();
    2.从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表的前端
    2.声明节点node用于记录当前节点temp.next
    4.temp.next = reverseHead.next
      reverseHead.next = temp
      temp = node;
     */
    public void reverseSingleLinkedList(){
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode temp = this.head.next;
        HeroNode node;
        while (temp != null){
            node = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = node;
        }
        this.head.next = reverseHead.next;

    }

    //从尾到头打印单链表
    /*思路1：先反转单链表，再打印，会破坏单链表结构
      思路2：利用栈的数据结构，将各个数据节点压入栈中，利用栈先进先出的特点打印
     */
    public void reversePrint(){
        if (this.head.next == null){
            return;
        }
        //创建一个栈，将各个节点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode temp = this.head.next;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        //将栈中的节点进行遍历打印
        while (stack.size() > 0){
            System.out.println(stack.pop());//栈的特点：先进后出
        }
    }

    //合并两个有序链表，并输出打印
    public void mergeSingleLinkedList(SingleLinkedListManage sll1, SingleLinkedListManage sll2){
        SingleLinkedListManage mergeLLM = new SingleLinkedListManage();
        HeroNode p = mergeLLM.getHead();
        HeroNode temp1 = sll1.head.next;
        HeroNode temp2 = sll2.head.next;
        while (temp1 != null && temp2 != null){
            if (temp1.no > temp2.no){
                p.next = temp2;
                temp2 = temp2.next;
            }else if (temp1.no < temp2.no){
                p.next = temp1.next;
                temp1 = temp1.next;
            }
            p = p.next;

        }

        if (temp1 != null) p.next = temp1;
        if (temp2 != null) p.next = temp2;

        mergeLLM.list();

    }

    public HeroNode getHead(){

        return this.head;
    }
}