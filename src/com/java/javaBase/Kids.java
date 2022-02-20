package com.java.javaBase;
/*
定义类Kids继承ManKind,
成员变量 int yearsOld
方法printAge() 打印yearsOld的值
 */
public class Kids extends Mankind {

    private int yearsOld;

    public Kids() {
    }

    public Kids(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void printAge(){
        System.out.println(yearsOld);
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }


}
/*
定义类KidsTest, 在类的main方法中实例化Kids的对象someKid,用该对象访问其父类的方法与属性
 */
class KidsTest{
    public static void main(String[] args){

        Kids someKid = new Kids(12);
        someKid.printAge();

        someKid.setSalary(3000);
        someKid.setSex(1);

        someKid.employeed();
        someKid.manorWoman();

    }
}


