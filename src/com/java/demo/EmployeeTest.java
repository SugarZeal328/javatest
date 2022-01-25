package com.java.demo;
import java.io.*;

public class EmployeeTest {
    public static void main(String []args){
        Employee empOne = new Employee("Sugar Zeal");
        Employee empTwo = new Employee("Adamin Levine");

        //调用这两个对象的成员方法
        empOne.emAge(22);
        empOne.emDesignation("master degree student");
        empOne.emSalary(600);
        empOne.printEmployee();

        empTwo.emAge(32);
        empTwo.emDesignation("band master singer");
        empTwo.emSalary(80000);
        empTwo.printEmployee();
    }
}
