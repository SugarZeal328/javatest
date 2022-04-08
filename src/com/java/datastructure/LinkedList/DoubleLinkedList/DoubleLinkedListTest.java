package com.java.datastructure.LinkedList.DoubleLinkedList;

public class DoubleLinkedListTest {

    public static void main(String[] args) {

        HeroDoubleLinkedList heroDoubleLinkedList = new HeroDoubleLinkedList();

        heroDoubleLinkedList.addByOrder(new DoubleHeroNode(3,"吴用", "智多星"));
        heroDoubleLinkedList.addByOrder(new DoubleHeroNode(2,"卢俊义", "玉麒麟"));
        heroDoubleLinkedList.addByOrder(new DoubleHeroNode(4,"我的饭", "我的饭"));
        heroDoubleLinkedList.addByOrder(new DoubleHeroNode(5,"我的", "我的"));

        heroDoubleLinkedList.list();
        System.out.println("**********************");
        //heroDoubleLinkedList.updateByOrder(new DoubleHeroNode(4,"林冲","老乌龟"));
        heroDoubleLinkedList.del(2);
        heroDoubleLinkedList.list();

    }


}
