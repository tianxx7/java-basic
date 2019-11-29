package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/*
 * ArrayList测试
 * */
public class ArrayListTest {

    /*
    * ArrayList扩容测试
    * 添加的时候先ensureCapacityInternal确认内部容量是否足够
    * 足够直接element[size++] = e
    * return true;
    * 如果不够
    * ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    * 计算容量,elementData == {} 返回minCapacity与默认容量的最大值
    *   不为{}直接返回minCapacity
    * ensureExplicitCapacity(minCapacity)
    * 如果minCapacity - elementData.length > 0 说明容器放不下新的元素,需要扩容
    *  grow(minCapacity);
    * 默认扩容是1.5倍,如果1.5倍<minCapacity newCapacity = minCapacity
    * 进行扩容 Arrays.copy()
    * */
    @Test
    public void arrayListGroup(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
    }

    /*
    *
    * */
    @Test
    public void addArrayListTest(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Integer[] array1 = new Integer[3];
        list.toArray(array1);
        Integer[] arrat2 = list.toArray(new Integer[0]);
        System.out.println(Arrays.equals(array1,arrat2)); // 1.true
        /*
        * 因为ArrayList有两个方法可以返回数组Object[] toArray() 和 <T> T[] toArray(T[] a)
        * 第一个方法返回的数组是通过Arrays.copyOf实现,
        * 第二个如果参数数组长度足以容纳所有元素,就使用参数数组,否则新建一个数组返回,所得结果为true
       * */


        Integer[] array = {1,2,3};
        List<Integer> list1 = Arrays.asList(array);
        list1.add(4);// 2 结果是什么,为什么
        //会抛出UnSupportOperationException,因为Arrays的asList方法返回的是一个Arrays内部类的ArrayList对象
        //这个对象没有实现add,remove等方法,只实现了set等方法,所以通过Arrays.asList转换的列表不具有结构可变性


        Integer[] array3 = {1,2,3};
        List<Integer> list3 = new ArrayList<>(Arrays.asList(array3));
        list3.add(4); // 3.可以正常
        //不可变结构的Arrays的ArrayList通过构造放入了真正的万能ArrayList
    }

    @Test
    public void removeTest(){
        ArrayList<String> list = new ArrayList<>();
        list.add("java");
        list.add("android");
        list.add("android");
        list.add("java");
        list.add("c");
        list.add("c++");
        list.add("c");

        //正确
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.equals("android")){
                list.remove(s);
            }
        }
        //原因是遍历删除的时候,后面的元素向前移动(System.copy),但是i一直向后,导致有些没有被遍历到
        System.out.println(list.size());// 6 总共7个,漏删除一个,解决办法是倒序遍历
        list.iterator();

        //ConcurrentModificationException
        //解决办法使用迭代器的remove方法
        /*for (String s : list){
            if (s.equals("android")){
                list.remove(s);
            }
        }*/
    }

    /*
    * Array.asList方法踩坑
    * */
    @Test
    public void asList(){
        int[] data = {1,2,3,4};
        List<int[]> ints = Arrays.asList(data);
        System.out.println(ints.size());//1
        //asList接收的是一个类型为T的数组,基本类型不能作为泛型,所以这里参数a只能接收引用类型
        //自然编译通过编译器就把上面的int[]数组当作一个引用参数,所以size为1
        Integer[] integers = {1,2,3,4};
        List<Integer> boxInt = Arrays.asList(integers);
        System.out.println(boxInt.size());//4
        boxInt.add(5);//这个抛出异常,Arrays.asList是个内部类ArrayList,没有实现add方法,
        // 只实现了size,toArray,get,set,contains几个方法
        //Arrays.asList返回的是一个不可变长度的列表
    }

    @Test
    public void listEquals(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("android");
        Vector<String> vector = new Vector<>();
        vector.add("android");
        System.out.println(strings.equals(vector));//true
        //集合列表只关心数值的比较,其equals方法都是AbstractList中实现的
        //比较的依据时通过迭代器遍历元素挨个equals比较,其他集合map,set同理
    }
}
