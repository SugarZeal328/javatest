package com.java.exercise.JavaCollection;

//java集合可以分为collection和map两种体系
/*collection接口：单列数据，定义了存取一组对象方法的集合
list：元素有序、可重复的集合，动态数组：arraylist, linkedlist, vector
set：元素无序，不可重复的集合，集合，无序，确定性，互异性: hashset, linkedhashset, treeset
 */
/*
Map接口：双列数据，保存具有映射关系"key value"一对一对的集合，一个key对应一个value

1.集合collection中存储的如果是自定义对象，需要自定义类重写equals()，设计collection中方法的调用
 */

import org.junit.Test;

import javax.xml.namespace.QName;
import java.util.*;

public class CollectionTest {
    public int no;
    public String name;

    public CollectionTest(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public CollectionTest() {}


    @Override
    public String toString() {
        return "CollectionTest{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CollectionTest)) return false;
        CollectionTest that = (CollectionTest) o;
        return no == that.no && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name);
    }

    public static void main(String[] args) {
        Collection coll = new ArrayList<>();

        //add(Object e)
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());

        //size()集合的长度，添加元素的个数
        coll.size();

        //addAll();将另外一个集合全部添加到当前集合中
        Collection coll1 = new ArrayList();
        coll1.addAll(coll);
        System.out.println(coll1.toString());

        //isEmpty() 判断当前集合是否为空，size == 0
        //clear()清空集合元素、
        //contains()判断当前集合中是否包含obj，判断的是内容
        //containsAll()
        coll.add(new CollectionTest(1,"zzz"));
        //未重写CollectionTest中的equals方法的话是false，重写了是true
        System.out.println(coll.contains(new CollectionTest(1,"zzz")));

        //向collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals()

        //remove()移除某个元素，返回值为boolean，同样会调用equals()
        //removeAll(Collection coll)从当前集合中移除coll中的所有元素
        System.out.println(coll.remove(new CollectionTest(1,"zzz")));

        //retainAll()求集合的交集（返回值，并修改调用对象的集合 ）
        Collection coll2 = Arrays.asList(123,456,789);
        Collection coll3 = Arrays.asList(789);
        System.out.println("coll2和coll3的交集：" + coll2.retainAll(coll3));

        //equals(Object obj):比较集合，和元素的值和位置都有关

        //hashcode() 返回当前对象的哈希值

        //toArray() 将集合转为数组
        Object[] arr = coll3.toArray();
        System.out.println(arr.toString());

        //数组转为集合：调用Array类的静态方法aslist()
        List list = Arrays.asList(new Integer[]{123,456});

        //iterator():返回Iterator接口的实例，用于遍历集合元素
        //集合元素的遍历操作，使用迭代器Iterator接口
        Collection coll4 = new ArrayList();

        //add(Object e)
        coll4.add("AA");
        coll4.add("BB");
        coll4.add(123);//自动装箱
        coll4.add(new Date());
        //iterator不是容器，只是个迭代器
        Iterator iterator = coll4.iterator();

        //hasNext() 判断是否还有下一个元素
        //next() 1⃣️指针下移，2⃣️将下移以后集合位置上的元素返回
        //每执行一次coll4.iterator()，就从头指针开始一个迭代器
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //remove() 移除当前元素，迭代器中的方法，非集合

        //foreach jdk5.0新增增强for循环, 内部用的也是迭代器，只能遍历，不能赋值
        for (Object obj : coll4){
            System.out.println(obj);
        }


    }
}
