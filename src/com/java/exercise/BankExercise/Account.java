package com.java.exercise.BankExercise;

public class Account {

    private int id;
    private double balance;
    private double annualInterestRate;

    public Account() {

    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;//账号
        this.balance = balance;//余额
        this.annualInterestRate = annualInterestRate;//年利率
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    //取钱
    public void withdraw(double amount) {
        if (this.balance < amount) {
            System.out.println("您的余额不足！");
        }else {

            this.balance = this.balance - amount;
            System.out.println("您取出￥" + amount + "当前余额￥" + this.balance);
        }
    }

    //存钱
    public void deposit(double amount) {
        this.balance = this.balance + amount;
        System.out.println("您存入￥" + amount + "当前余额￥" + this.balance);
    }
}
