package com.java.exercise.ExceptionTest;

import org.junit.Test;

/*
编写应用程序EcmDef.java, 接收命令行的两个参数，要求不能输入负数，计算两数相除
对数据类型不一致的（NumberFormatException),缺失命令行参数(ArrayIndexOutBoundException)
和除0(ArithmeticException)及输入负数(EcDef 自定义异常类)进行异常处理
 */
/*
throw和throws的区别
throw：生成一个异常对象并抛出，使用在方法内部———手动抛出,在方法头中
throws：处理异常的方式，用于处理异常，使用在方法声明的末尾，相当于try-catch-finally
 */
public class ExceptionExercise {
    public static void main(String args[]){

        //包装类复习：Integer.parseInt() 返回一个int值
        //Integer.valueOf()则返回一个Integer对象(若在-128~127内，返回数组元素，超过则新建一个引用对象)
        try {
            int i = Integer.valueOf(args[0]);
            int j = Integer.valueOf(args[1]);

            int result  = EcmDef.ecm(i,j);

            System.out.println(result);
        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }catch (ArithmeticException e){
            e.printStackTrace();
        }catch (EcDef e){
            System.out.println(e.getMessage());
        }


    }
}

class EcmDef{

    public static int ecm(int i, int j) throws EcDef{
        //抛出的非运行时异常,需考虑处理，添加throws EcDef
        if (i < 0 || j < 0) throw new EcDef("输入数值为负");//手动抛出异常
        return i/j ;
    }

}

/*
自定义异常类
1.继承现有的体系结构
2.自己的序列版本号
3.重载的构造器
 */
class EcDef extends Exception {

    //类的标识
    static final long serialVersionUID = -3387516994229948L;

    public EcDef() {
    }

    public EcDef(String message) {
        super(message);
    }
}