package com.java.javaBase;
/*
定义一个Mankind类，包括
成员变量int sex, salary
方法void manOrwoman(), 根据sex的值显示“man”（sex == 1）和“woman”（sex == 0）
方法void employeed(), 根据salary的值显示“no job"（salary == 0）和“job"(salary != 0)
 */
public class Mankind {

    private int sex;
    private int salary;

    public Mankind() {
    }

    public  void manorWoman(){
        if (sex == 1){
            System.out.println("man");
        }else if (sex == 0){
            System.out.println("woman");
        }
    }

    public void employeed(){
       String jobInfo = (salary == 0)?"no job" : "job";
       System.out.println(jobInfo);
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
