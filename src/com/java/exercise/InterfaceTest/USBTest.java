package com.java.exercise.InterfaceTest;

import org.junit.Test;
/*
接口使用
1.接口的多态性：接口实现类可满足使用接口形参的方法
2.接口实际上是一种定义的规范，实现接口的类必须拥有接口中定义的抽象方法
3.面向接口编程
 */
public class USBTest {
    @Test
    public void test() {
        Computer pc1 = new Computer();
        //接口非匿名实现类的匿名对象
        pc1.transferData(new Flash());

        //接口匿名实现类的非匿名对象
        USB phone = new USB() {
            @Override
            public void speed() {
                System.out.println("USB2.0");
            }
        };
        pc1.transferData(phone);

        //接口匿名实现类的匿名对象
        pc1.transferData(new USB() {
            @Override
            public void speed() {
                System.out.println("接口匿名实现类的匿名对象");
            }
        });
    }
}

interface USB {
    //接口的长宽高，传输速度等
     void speed();
}

class Flash implements USB {
    @Override
    public void speed(){
        System.out.println("USB3.0");
    }
}

class Computer {

    //这里传入USB接口实现类的对象
    public void transferData(USB usb){
        usb.speed();

        System.out.println("数据传输");
    }
}