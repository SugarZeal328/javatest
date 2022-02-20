package com.java.exercise.JavaCollection;

import com.java.javaBase.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/*collection接口：单列数据，定义了存取一组对象方法的集合
list：元素有序、可重复的集合，动态数组：arraylist, linkedlist, vector
set：元素无序，不可重复的集合，集合，无序，确定性，互异性: hashset, linkedhashset, treeset

HashSet:Set的首要实现类， 线程不安全，可以存储null值，默认长度为16
LinkedHashList: 作为HashSet的子类，遍历时可以按照添加的顺序遍历
TreeSet: 可以按照添加的对象的指定属性进行排序

无序的理解：相较于List的空间线性存储，Set并非按照数组索引的顺序添加，而是根据数据的哈希值存储
不可重复性：保证添加的元素按照equals方法判断时不能返回true，即相同的元素

Set作为子接口，无定义新的方法，使用Collection中的方法
 */
public class SetTest {

    @Test
    public void test1() {
        /*
        HashSet添加元素的过程：向HashSet中添加元素A，首先调用A的hashcode()，计算A的哈希值，
        此哈希值直接通过某种算法计算出HashSet底层中存放位置，判断数组此位置上是否已经有其他元素
        如果此位置没有元素，则元素A添加成功，
        如果此位置有其他元素B，则比较两者哈希值，-----情况1
        如果两者不同，则存储，------情况2
        如果相同，则调用A的equals(),
        返回true：相同，添加失败
        返回false：不同，添加失败 -------情况3

        情况2和3，元素A和B在指定索引位置上以链表的方式存储
        jdk7中，元素A放到数组中，指向原来的元素
        jdk8中，原来的元素在数组中，指向元素A

        HashSet的底层：数组➕链表

        向Set中添加的元素，其所在类一定要重写hashCode()和equals(),
        重写的hashCode()和equals()尽可能保持一致性，相等的对象必然具有相等的哈希值

         */
        HashSet set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        //因为没有重写person中的equals()和hashCode(),两个元素的地址值不同，故不重复
        set.add(new Person(23,"Tom"));
        set.add(new Person(23,"Tom"));
        set.add(129);

        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
    /*
    LinkedHashSet仍然是无序的，但可以按照添加顺序遍历
    作为HashSet的子类，在添加数据时，每个数据还维护类两个引用：prev和last
    对于频繁遍历，LinkedHashSet效率较高
     */

    /*
    TreeSet：可以按照对象的指定属性进行排序，通过compareTo()比较元素是否相等，返回0则认为相等,底层采用的是红黑树结构
    1.向TreeSet中添加的数据必须为同一个类提供的
    2.可使用自然排序与定制排序
    3.自然排序时，比较两个对象是否相等使用的compareTo(),不再是equals()

     */
        TreeSet set = new TreeSet<>();
        set.add(new Person(23,"Tom"));
        set.add(new Person(22,"Jim"));
        set.add(new Person(24,"Jim"));

        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }

        System.out.println("*********************************");

        //定制排序，按年龄从大到小
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;

                    int i =  -Integer.compare(p1.getAge(), p2.getAge());

                    if (i != 0) return i;
                    else return p1.name.compareTo(p2.name);
                }
                throw new RuntimeException("输入数据类型错误");
            }
        };

        TreeSet set1 = new TreeSet<>(com);
        set1.add(new Person(23,"Tom"));
        set1.add(new Person(22,"Jim"));
        set1.add(new Person(24,"Jim"));

        Iterator iterator1 = set1.iterator();

        while (iterator1.hasNext()){
            System.out.println(iterator1.next().toString());
            //p540
        }

    }


}
