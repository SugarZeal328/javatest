package com.java.exercise.BankExercise;

public class BankTest {

    public static void main(String[] args){
        Bank bk1 = new Bank();

        bk1.addCustomers("ZZ", "lp");
        bk1.addCustomers("wd", "dd");

        bk1.getCustomer(0).setAccount(new Account(001, 10000, 0.01));

        bk1.getCustomer(0).getAccount().withdraw(100);


    }
}
