package com.java.exercise.AnnotationTest;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

@Inherited
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)//指明所修饰注解的生命周期
public @interface MyAnnotation {
    //自定义注解：参照@SuppressWarnings
    //如果自定义呃注解没有成员，则表明是一个标识
    //如果注解有成员，在使用注解时，需要指明成员的值
    //自定义注解必须配上注解使用流程才有意义，即使用反射
    //元注解：对现有注解进行解释说明的注解
    MyAnnotations[] value();

}
