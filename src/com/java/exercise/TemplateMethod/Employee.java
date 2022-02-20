package com.java.exercise.TemplateMethod;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

abstract public class Employee {
    private String name;
    private int number;
    private Mydata birthday;

    public Employee() {}

    public Employee(String name, int number, Mydata birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    abstract public int earning(Mydata salaryMonth);

    @Override
    abstract public String toString();

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Mydata getBirthday() {
        return birthday;
    }
}

class SalariedEmployee extends Employee {

    private int monthlySalary;

    public SalariedEmployee() {

    }

    public SalariedEmployee(String name, int number, Mydata birthday, int monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    public SalariedEmployee(String name, int number, Mydata birthday) {
        super(name, number, birthday);
    }

    @Override
    public int earning(Mydata salaryMonth) {
        if (this.getBirthday().getMonth() == salaryMonth.getMonth()) {
            return monthlySalary = monthlySalary + 100;
        }
        return monthlySalary;

    }

    @Override
    public String toString() {
        return "姓名： " + getName() + ", 工号： " + getNumber()
                + "， 当月薪资: " + monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary){
        this.monthlySalary = monthlySalary;
    }

    public int getMonthlySalary(){
        return monthlySalary;
    }



}

class HourlyEmployee extends Employee {

    private int wage;
    private int hour;
    private int monthlySalary;

    public HourlyEmployee(String name, int number, Mydata birthday, int wage, int hour){
        super(name, number, birthday);
        this.hour = hour;
        this.wage = wage;

    }

    @Override
    public int earning(Mydata salaryMonth) {
        if (this.getBirthday().getMonth() == salaryMonth.getMonth()) {

            return monthlySalary = wage*hour + 100;
        }
        return monthlySalary = wage*hour;
    }

    @Override
    public String toString(){

        return "姓名： " + getName() + ", 工号： " + getNumber()
                + ", 时薪: " + wage + ", 工作时长： " + hour + ", 当月薪资： " + monthlySalary;

    }

}

class Mydata{

    private int year;
    private int month;
    private int day;

    public Mydata() {

    }

    public Mydata(int year, int month, int day) {
        if (month < 1 || month > 12) throw new RuntimeException("请输入正确月份");
        if (day < 1 || day > 31) throw new RuntimeException("请输入正确日期号");
        switch (month) {
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                    if (day > 29) throw new RuntimeException(month + "月天数溢出！");
                }else if (day > 28) throw new RuntimeException(month + "月天数溢出！");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
            case 10:
            case 12:
                if (day > 30) throw new RuntimeException(month + "月天数溢出！");
                break;
        }


        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return year + "年" + month + "月" + day + '日';
    }
}



class MydataTest {


    public static void main(String[] args) {
        Mydata data1 = new Mydata();

        Scanner sc = new Scanner(System.in);

        System.out.print("请输入月份：");
        int month = sc.nextInt();

        data1.setMonth(month);

        //通过数组实现Employee抽象类的匿名对象
        Employee[] emp = new Employee[2];

        emp[0] = new SalariedEmployee("张宗中",205920004, new Mydata(1998,3,28), 3000);
        emp[1] = new HourlyEmployee("瓦利哦", 2016214692, new Mydata(1998,3,28),100,160);

        System.out.println("****" + data1.getMonth() + "月工资****");
        for (Employee em : emp){
            em.earning(data1);
            System.out.println(em);
        }




    }

}