package com.java.javaBase;

import java.util.Objects;

public class Person implements Comparable{

    private int age;
    public String name;

    //类的构造器：权限修饰符 ＋ 类名（形参）
    public Person(int age){
        this.age = age;
        System.out.println(age);
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    //通常会提供一个空参的构造器
    public Person(){

    }

    public Person(String str, int age){
        this(age);
        System.out.println("构造器的重载");
    }

    public void setAge(int age) {
        if (age < 0 || age > 130) {
            //throw new RuntimeException("传入非法数据")
            System.out.println("传入非法数据");
            return;
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Person){
            Person p = (Person) o;
            int i = this.name.compareTo(((Person) o).name);
            if (i != 0 ) return i;
            else return Integer.compare(this.age, p.age);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
