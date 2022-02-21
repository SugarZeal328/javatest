package com.java.exercise.JavaCollection.TreeSetTest;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

/*
定义一个employee类，
包含private成员变量：name, age, birthday(MyDate类对象)
写成每个属性的get set 方法，重写该类的toString()
 */
public class Employee implements Comparable {

    private String name;
    private int age;
    private MyDate birthday;

    static Calendar cal = Calendar.getInstance();

    public Employee(String name, MyDate birthday) {
        this.name = name;
        this.age = cal.get(Calendar.YEAR) - birthday.getYear();
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee){
            Employee e = (Employee) o;

            int i = this.name.compareTo(e.name);

            if (i != 0) return i;
            else return this.age - e.age;
        }
        throw new RuntimeException("数据异常");
    }

}
/*
private year， month， day
        为该类创建5个对象，放在TreeSet中
        按一下两种方式排序
        1.使Employee实现comparable接口，并按name输出
        2.创建TreeSet时传入comparator对象，按生日日期的先后排序
        */
class MyDate {

    private int year, month, day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyDate)) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}

class Test {
    public static void main(String[] args) {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){
                    return ((Employee) o1).getAge() - ((Employee) o2).getAge();
                }else return 0;
            }
        };

        Employee e1 = new Employee("A", new MyDate(1990,3,28));
        Employee e2 = new Employee("D", new MyDate(1993,3,28));
        Employee e3 = new Employee("C", new MyDate(1991,3,28));

        TreeSet empSet = new TreeSet<>(comparator);

        empSet.add(e1);
        empSet.add(e2);
        empSet.add(e3);

        for (Object o : empSet){
            System.out.println(o.toString());
        }
    }
}
