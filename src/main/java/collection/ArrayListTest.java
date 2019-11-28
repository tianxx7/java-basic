package collection;

import org.junit.Test;

import java.util.ArrayList;

/*
 * ArrayList测试
 * */
public class ArrayListTest {

    /*
    * ArrayList扩容测试
    * */
    @Test
    public void arrayListGroup(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
    }
}
