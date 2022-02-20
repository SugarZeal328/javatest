package com.java.exercise;

public class EqualTest {

    int num;

    public EqualTest() {
    }

    public EqualTest(int num){
        this.num = num;
    }

    //自定义类如何重写equal方法，比较两个对象的实体内容是否相同
    //对object类中的方法重写


    @Override//自动生成equals重写
    public boolean equals(Object o) {
        if (this == o) return true;//地址相等
        if (o == null || getClass() != o.getClass()) return false;//空值或者类不相同
        EqualTest test = (EqualTest) o;
        return num == test.num;
    }


    /*@Override //手动实现equals重写
    public boolean equals(Object obj) {
        if (this == obj){
            return true;//地址相同内容必相等
        }else if (obj instanceof EqualTest){
            //比较两个对象的属性是否相同
            EqualTest test = (EqualTest)obj;
            if (this.num == test.num) return true;
            else return false;

        }
        return false;
    }
     */


    public static void main(String[] args){
        int i =10;
        int j =10;
        double d = 10.0;
        System.out.println(i == d);//true

        boolean b = true;
        //System.out.println(i == b);//错误，其他基本数据类型无法与布尔类型比较

        String str1 = new String("zzz");
        String str2 = new String("zzz");
        System.out.println(str1 == str2);//false 引用数据类型比较地址值

        System.out.println("**********************");
        EqualTest t1 = new EqualTest(1);
        EqualTest t2 = new EqualTest(1);

        System.out.println(t1.equals(t2));//若没用重写equal（）方法是false，重写了则是true

        System.out.println("**********************");
        System.out.println(str1.equals(str2));//true

        /*
        //String类种重写了equal方法
        public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;//比较地址值
        }
        if (anObject instanceof String) {
            String anotherString = (String)anObject;
            int n = value.length;
            if (n == anotherString.value.length) {
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                else return true;
            }
        }
        return false;
    }
         */
    }
}
