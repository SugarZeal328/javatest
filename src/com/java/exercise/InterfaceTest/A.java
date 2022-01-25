package com.java.exercise.InterfaceTest;

import org.junit.Test;

class test {
    @Test
    public static void main(String[] args) {

        A ac4 = new C4();
        B bc4 = new C4();
        C3 c34 = new C4();

        ac4.play();
        bc4.play();
        c34.play();

    }
}

public interface A {
    int x = 1;//全局常量，省略了public static final
    void play();
}

interface B {
    void play();
}

class C1 {
    int x = 1;
}

class C2 extends C1 implements A, B {
    void px() {
        System.out.println(A.x);//这里的X必须明确：A.X或super.x(B.x)
    }

    //该方法的重写是对A,B两接口中同名方法的重写
    @Override
    public void play() {
        System.out.println("just play");
    }
}

abstract class C3 {
    abstract public void play();
}

class C4 extends C3 implements A, B {

    //该方法的重写是对继承的抽象类和实现的所有接口中play方法的重写
    @Override
    public void play() {
        System.out.println("重写");
    }
}
