package collection;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

    /*
    * 集合工具类的排序方法
    * */
    @Test
    public void collections_sort(){
        List<Info> list = new ArrayList<>();
        list.add(new Info("小渔村", 0756)); // 八进制
        list.add(new Info("珠海",0756));


        Collections.sort(list);
        Info info = new Info("小渔村", 0756);
        list.forEach(System.out::println);
        /*
        * Info{name='珠海', age=494}
        * Info{name='小渔村', age=494}
        * */

        int index1 = list.indexOf(info);
        int index2 = Collections.binarySearch(list,info);
        System.out.printf("index1 = " + index1 +"%nindex2 = " + index2);
        /*
        * index1 = 0
        * index2 = 1
        *
        * indexOf是调用equals方法去查找,所以使用的是age相等,第一个就符合条件,所以index1是0
        * Collections.binarySearch是用compareTo方法查找,所以是用name的length
        *
        * 集合中的元素必须做到compareTo与equals方法结果同步,
        * 由于equals判断的是元素是否相等,binarySearch判断的是元素在排序中的位置是否相等,
        * indexOf通过equals方法进行判断,而Collections.binarySearch是依据compareTo方法进行判断,所以结果不同
     * */
    }
}
