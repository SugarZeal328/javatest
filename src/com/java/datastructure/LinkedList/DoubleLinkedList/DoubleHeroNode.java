package com.java.datastructure.LinkedList.DoubleLinkedList;


public class DoubleHeroNode {
        public int no;
        public String name;
        public String nickName;
        public DoubleHeroNode pre;//指向前一个节点
        public DoubleHeroNode next;//指向下一个节点

        public DoubleHeroNode(){

        }

        public DoubleHeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
        }

        @Override
        public String toString() {
            return "DoubleHeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }

}
