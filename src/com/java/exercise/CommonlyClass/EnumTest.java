package com.java.exercise.CommonlyClass;

import org.junit.Test;

public class EnumTest {
    @Test
    public void testEnum() {

        Season spring = Season.SPRING;
        Season1 spring1 = Season1.SPRING;

        System.out.println(spring);
        System.out.println(spring1);

        //Enum values() 遍历枚举类中的所有值，返回成该类的数组
        Season1[] season1 = Season1.values();
        for (Season1 s : season1){
            System.out.println(s);
        }

        //Enum valueOf() 根据提供的字符串返回对应的常量
        System.out.println(Season1.valueOf("WINTER"));



    }
}

class Season{
    private final String seasonName;
   private final String seasonDesc;

    public Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    public static final Season SPRING = new Season("春","春");
    public static final Season SUMMER = new Season("夏","夏");
    public static final Season FALL = new Season("秋","秋");
    public static final Season WINTER = new Season("冬","冬");
}
//通过enum关键字创建枚举类
//每个枚举类对象可以单独重写接口方法

@SuppressWarnings(value = "used")
enum Season1 implements Weather {

    SPRING("春","春"){
        @Override
        public void weather() {
            System.out.println("春雨");
        }
    },
    SUMMER("夏","夏"){
        @Override
        public void weather() {
            System.out.println("暴雨");
        }
    },
    FALL("秋","秋"){
        @Override
        public void weather() {
            System.out.println("飓风");
        }
    },
    WINTER("冬","冬"){
        @Override
        public void weather() {
            System.out.println("暴雪");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }



    //toSring方法被其父类Enum重写为返回对象名
}

interface Weather {
    void weather();
}

//声明注解
@interface MyAnnotation {

}