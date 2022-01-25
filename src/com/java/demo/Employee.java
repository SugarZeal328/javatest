package com.java.demo;
import java.io.*;

public class Employee {
    String name;
    int age;
    String designation;
    double salary;
    //Employee类的构造器
    public Employee(String name){
        this.name = name;
    }
    //设置age的值
    public void emAge(int emAge){
        age = emAge;
    }
    //设置designatio的值
    public void emDesignation(String emDesign){
        designation = emDesign;
    }
    //setting salary value
    public void emSalary(double emSalary){
        salary = emSalary;
    }
    //print employee's informatom
    public void printEmployee(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Designation: "+designation);
        System.out.println("Salary: "+salary);
        System.out.println();
    }
}
