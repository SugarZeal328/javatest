package com.java.datastructure.LinkedList.DoubleLinkedList;


public class HeroDoubleLinkedList {

    private final DoubleHeroNode head = new DoubleHeroNode(); //头节点


    //遍历方法与单链表相同
    public void list() {
        //先判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //利用辅助变量遍历
        DoubleHeroNode temp = head.next;
        while (true) {
            //判断是否到最后
            if (temp == null) break;
            System.out.print(temp.toString() + " \n");
            temp = temp.next;
        }
    }

    //添加-到末尾
    public void add(DoubleHeroNode heroNode) {

        DoubleHeroNode temp = head;
        //找到末尾节点
        while (true) {

            if (temp.next == null) break;

            temp = temp.next;
        }

        temp.next = heroNode;
        heroNode.pre = temp;

    }

    //按no添加
    public void addByOrder(DoubleHeroNode heroNode) {
        //头节点不可动，通过辅助指针帮助我们遍历节点
        DoubleHeroNode temp = head;
        boolean flag = false;//判断添加的节点是否存在
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                heroNode.pre = temp;
                break;
            }

            if (temp.next.no > heroNode.no) {
                //此时找到了heroNode应在的位置
                temp.next.pre = heroNode;
                heroNode.pre = temp;
                heroNode.next = temp.next;
                temp.next = heroNode;

                break;
            }

            if (temp.next.no == heroNode.no) {
                throw new RuntimeException("链表中的该编号已存在");
            }

            temp = temp.next;
        }
    }

    //按no修改
    public void updateByOrder(DoubleHeroNode heroNode) {
        DoubleHeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                System.out.println("链表已遍历完");
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else System.out.printf("未找到编号%d的节点\n", heroNode.no);

    }

    //按no删除
    public void del(int no) {
        DoubleHeroNode temp = head;
        Boolean flag = true;
        //找到no号节点
        while (flag) {

            if (temp == null) {
                System.out.printf("已遍历完，未找到no.%d节点", no);
                System.out.println();

                break;
            }

            if (temp.no == no) {
                //修改被删除节点pre的next 和 next的pre
                temp.pre.next = temp.next;
                //warning：如果删除的是最后一个节点，就不需要执行temp.next.pre = temp.pre;，否则会空指针异常
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }

                break;
            }

            temp = temp.next;


        }
    }

}

