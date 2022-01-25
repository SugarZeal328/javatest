package com.java.exercise.staticTest;
/*
* 编写一个类实现银行账户的概念，包含属性有“账号”，“密码”。，“存款余额”
“利率”，“最小余额”
* 定义封装这些属性的方法
    编写主类，使用银行账户类，输入，输出三个储户的上述信息
    考虑：哪些类可以使用static属性
 */
public class account {

    private int id;
    private String pwd;
    private double balance;

    private static double interestRate;
    private static double minMoney = 1.0;
    private static int init = 1001;//用于自动生成ID

    public account() {
        id = init++;
    }

    public account(String pwd, double balance) {
        this.pwd = pwd;
        this.balance = balance;


        id = init++;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        account.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "account{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", balance=" + balance +
                '}';
    }
}

class AcountTest{

    public static void main(String[] args){

        account a1 = new account();
        account a2 = new account("880528",900.0);
        System.out.println(a1 + "\r\n" + a2);
    }
}
