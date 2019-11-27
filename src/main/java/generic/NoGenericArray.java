package generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
* 不能有泛型数组
* */
public class NoGenericArray {

    @Test
    public void genricArrayTest(){
        //List<String>[] lsa = new List<String>()[10]; // no really allowed
        /*Object o = lsa;
        Object[] oa = (Object[])o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li;
        String s = lsa[1].get(0);*/
        //jvm泛型的擦除机制,所以上面代码可以给oa[1]赋值为ArrayList也不会抛出异常,但是在
        //取出数据时候要做一次类型转换,所以就会出现ClassCastException
        //如果可以进行泛型数组的声明则上面说的这种情况在编译期间不会出现任何警告和错误,
        //只有运行时才会出错,但是泛型的出现就是为了消灭ClassCastException,所以如果
        //Java支持泛型数组初始化操作就是搬起石头砸自己的脚
        //对于下面代码是成立的
        List<?>[] lsa = new List<?>[10];
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<>();
        li.add(new Integer(3));
        oa[1] = li;
        Integer i = (Integer)lsa[1].get(0);
        System.out.println(i);
        //采用通配符的方式初始化泛型数组是允许的,因为对于通配符的方式最后取出数据是要做显示类型转换的
        //符合预期逻辑,
        //综述就是说,Java的泛型数组初始化时数组类型不能是具体的泛型类型,只能是通配符的形式
        //因为具体类型会导致可存入任意类型的对象,在取出时就会发生类型转换异常,会与泛型的设计思想冲突
        //而通配符形式本来就要自己强转,符合预期














    }
}
