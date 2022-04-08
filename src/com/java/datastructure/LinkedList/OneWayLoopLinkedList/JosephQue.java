package com.java.datastructure.LinkedList.OneWayLoopLinkedList;

public class JosephQue {

    public static void main(String[] args) {

       CircleSingleLinkedList circleSingleLinkedList =  new CircleSingleLinkedList();

       circleSingleLinkedList.addBoy(25);
       circleSingleLinkedList.countBoy(1,2,25);

    }
}
//创建单向环形链表
class CircleSingleLinkedList {
    //创建一个first节点，当前没有编号
    private Boy first = new Boy(-1);
    //添加小孩节点，构建成一个环形的列表
    public void addBoy(int nums) {
       //辅助节点
        Boy temp = null;
        //nums做数据校验
        if (nums < 1) System.out.println("nums value error");
        //for来创建环形列表
        for (int i =1; i <= nums; i++){
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if ( i==1 ){

                first = boy;
                first.setNext(first);//构成环状
                temp =first; //让temp指向first，为后面的节点插入作准备


            } else {

                temp.setNext(boy);//打开环，让boy成为最后插入的节点
                boy.setNext(first);//闭合环，让boy指向first
                temp = boy;//继续将temp游标放置在最后插入的节点上

            }

        }

    }

    public void showLinkedList() {
        //判断链表是否为空，空则不打印
        if (first.getNext() == null) {
            System.out.println("单向♻️链表为空");
        } else {

            Boy temp = first;

            while (true) {
                System.out.println("boy no." + temp.getNo());
                if (temp.getNext() == first){
                    System.out.println("遍历结束");
                    break;
                }else temp = temp.getNext();
            }
        }


    }

    //joseph问题：根据用户的输入，输出出圈顺序

    /**
     *
     * @param startNO 表示从第几个开始数
     * @param countNum 表示书数几次
     * @param nums 初试♻️链表中的节点个数
     */
    public void countBoy(int startNO, int countNum, int nums) {
        //数据校验
        if(first == null || startNO < 1 || startNO > nums) {
            System.out.println("♻️链表c参数有误 ");
            return;
        }

        //创建辅助指针helper
        Boy helper = first;
        while (true){
            if (helper.getNext() == first){
                break; //找到循环链表的最后一个节点
            }else helper = helper.getNext();
        }

        //报数前先让first和helper移动K-1次
        for (int i = 1; i < startNO; i++){
            first = first.getNext();
            helper = helper.getNext();

        }

        while (true) {
            if (helper == first) { //最后一个和第一个相同，说明此时仅剩一个节点
                break;

            }
            //让helper和first指针同时移动countNum-1次
            for (int j = 1; j < countNum; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            //此时first指向的节点就是出圈的节点
            System.out.println("当前出圈的是：no." + first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后出⭕️的是" + first.getNo());


    }



}

//创建一个boy类，表示一个节点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}