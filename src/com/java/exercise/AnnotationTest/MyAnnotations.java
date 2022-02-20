package com.java.exercise.AnnotationTest;

import java.lang.annotation.*;
import java.lang.reflect.Type;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

@Inherited
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyAnnotation.class)//可重复注解
public @interface MyAnnotations {
 //jdk8中的注解新特性

    String[] value() default "annotation";//这里的value()是属性，可以设置默认值

}


