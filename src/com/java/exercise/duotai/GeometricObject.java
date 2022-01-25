package com.java.exercise.duotai;
/*
父类GeometricObject代表几何形状，子类Circle代表圆，MyRectangle代表矩形
定义一个测试类GeometricTest,编写equalsArea方法测试两个对象的面积是否相等（使用动态绑定）
编写displayGeometricObject方法显示对象面积（动态绑定）



 */
public class GeometricObject {
    private String color;
    private double weight;

    public GeometricObject() {
    }

    public GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double findArea(){
        double s = weight * weight;
        return s;
    }

}

class Circle extends GeometricObject{
    private double radius;

    public Circle() {

    }

    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double findArea() {
        double s = radius*radius * Math.PI;
        return s;
    }

    @Override//判断两个圆的半径是否相等
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj instanceof Circle){
            Circle c = (Circle)obj;
            return c.radius == this.radius;
        }else return false;
    }

}

class MyRectangle extends GeometricObject{
    double height;

    public MyRectangle() {

    }

    public MyRectangle(String color, double weight, double height) {
        super(color, weight);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double findArea() {
        double s = height*getWeight();
        return s;
    }
}

class GeometricTest{

    public void  equalsArea(GeometricObject gob1, GeometricObject gob2){

        boolean flag;
        if (gob1.findArea() == gob2.findArea()) flag = true;
        else flag = false;

        System.out.println(flag);
    }

    public void displayGeometricObject(GeometricObject gob3){
        System.out.println(gob3.findArea());
    }

    public static void main(String[] args){
        GeometricTest gtest = new GeometricTest();
        GeometricObject yuan = new Circle("red", 0.0, 1.0);
        GeometricObject yuan1 = new Circle("red", 0.0, 1.0 );
        GeometricObject ju = new MyRectangle("blue", 3.0, 2.0);


        gtest.equalsArea(yuan,ju);
        gtest.displayGeometricObject(yuan);
        gtest.displayGeometricObject(ju);
        System.out.println(yuan.equals(yuan1));
    }
}


