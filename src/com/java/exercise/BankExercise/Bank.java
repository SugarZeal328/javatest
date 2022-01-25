package com.java.exercise.BankExercise;

public class Bank {

    private Customer[] customers = new Customer[10];
    private int numerOfCustomers;

    public Bank() {

    }

    //添加客户
    public void addCustomers(String f, String l){
        Customer cust = new Customer(f, l);
        customers[numerOfCustomers++] = cust;

    }

    public int getNumerOfCustomers(){
        return numerOfCustomers;

    }

    //获取指定位置上的用户
    public Customer getCustomer(int index){
        if (customers.length > index && index >= 0){
            return customers[index];
        }

        return null;
    }

}
