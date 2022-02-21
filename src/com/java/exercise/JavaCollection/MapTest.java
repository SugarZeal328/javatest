package com.java.exercise.JavaCollection;

import com.java.javaBase.Person;
import org.junit.Test;

import java.util.*;

/*
Map：双列数据，存储key-value对的数据，
    HashMap:作为Map的主要实现类，线程不安全，效率高，可以存储null的key和value
        LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现，在原有的HashMap的基础上，添加了一对指针，
        指向前一个和后一个，对于频繁的遍历操作，此类执行效率高于HashMap
    TreeMap：保证按照添加的key-value对进行排序，实现排序遍历，底层使用的是红黑树
    Hashtable：古老实现类，线程安全，效率低，不可存储null
        Properties:

        HashMap的底层：数组➕链表（jdk7之前）
                      数组➕链表➕红黑树（jdk8）

        Map结构的理解：
        key不能重复，无序，相当于用set存储: key所在类重写hashcode()和equals()
        value可重复，无序，相当于使用collection存储: value所在类需要重写equals() (比较属性值，而非地址值)
        一个key-value存储在：entry(key, value):无序，不可重复（set）

        HashMap的实现原理，以Jdk7为例
        HashMap map = new HashMap();
        底层创建长度为16的Entry[]数组

        map.put(key1, value1);
        首先调用key1的hashCode()计算key1的哈希值，经过计算后得到在Entry数组中的存放位置
        如果此位置上数据为空，则(key1, value1)添加成功-------情况1
        如果此位置上数据不为空，（意味着此位置上存在一个或多个数据（以链表的形式存在）），则比较key1与
        多个值的哈希值：
            如果key1的哈希值与已经存在的数据的哈希值不同，则(key1, value1)添加成功-------情况2
            如果key1的哈希值与已经存在的数据哈希值相同，继续比较：调用key1所在类的equals(),比较：
                返回false，(key1, value1)添加成功-------情况3
                返回true，使用value1替换value2，添加变成替换
        补充：情况2和情况3，此时(key1, value1)和原来的数据以链表的形式存储
        在不断添加的过程中，Entry[]扩容，扩容为原来容量的两倍，并将原有数据复制

        jdk8中，
        1. new HashMap()底层没有创建长度为16的Node[]
        2. jdk8中的底层数组是：Node[]
        3. 首次调用put()方法时，底层查创建16长度的Node[]
        4. jdk7底层结构只有数组➕链表，jdk8中底层结构为数组➕链表➕红黑树
           当数组的某一个索引位置上的元素以链表形式存储的数据超过8，且当前数组的长度大于64时
           此时索引位置上的所有数据改为红黑树存储

        面试：
        1.hashmap的底层实现原理
        2.hashmap和hashtable的区别
        3.CurrentHashMap和Hashtable的区别
 */
public class MapTest {

    @Test
    public void test1() {
        HashMap hashMap = new HashMap();//容量，影响因子，16*0.75 = 12临界值, 超过12时开始扩容
        hashMap.put(null,null);

        //常用方法：添加删除修改
        //put(), putAll(), remove(), clear()

        hashMap.put("AA", 123);
        hashMap.put("BB", 456);

        HashMap hashMap1 = new HashMap<>();

        hashMap1.putAll(hashMap);
        System.out.println(hashMap1);

        //移除对应的key-value,返回移除的值
        hashMap1.remove("AA");

        //clear() 与 hashmap = null不同，此时不为空
        hashMap1.clear();
        System.out.println(hashMap1.size());

        //get(Object key)查找
        System.out.println(hashMap.get("AA"));

        //containsKey(); containsValue();
        System.out.println(hashMap.containsKey("BB"));
        System.out.println(hashMap.containsValue(123));

        //遍历：通过key遍历
        /*
        元视图操作方法
        Set keySet(): 返回所有key构成的set集合
        Collection values(): 返回所有value构成的Collection集合
        Set entrySet(): 返回所有key-value对构成的Set集合
         */

        Set set = hashMap.keySet();
        Collection collection = hashMap.values();
        Set entryset = hashMap.entrySet();

        for (Object obj : set){
            System.out.println(obj);
        }

        for (Object obj : collection){
            System.out.println(obj);
        }

        for (Object obj : entryset){
            System.out.println(obj);
        }


    }

    @Test
    public void test2() {

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    return ((Person) o1).getAge() - ((Person) o2).getAge();
                }else return ((Person) o1).name.compareTo(((Person) o2).name);
            }
        };
        //TreeMap:要求key必须是同一个类所创建的对象
        TreeMap treeMap = new TreeMap<>(comparator);

        Person p1 = new Person(20,"Tom");
        Person p2 = new Person(22,"Doom");
        Person p3 = new Person(26,"Tim");

        treeMap.put(p1,1);
        treeMap.put(p2,2);
        treeMap.put(p3,3);

        Set entryset = treeMap.entrySet();

        Iterator iterator = entryset.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test3() {
        //Properties: 常用来处理配置文件，key 和 value 都是String类型

        Properties properties = new Properties();

    }
}
