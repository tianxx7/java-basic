package basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListGetClass {

    @Test
    public void getClassTest(){
        List list1 = new ArrayList();
        List list2 = new ArrayList(){};
        List list3 = new ArrayList(){{}};
        List list4 = new ArrayList(){{}{}{}};
        System.out.println(list1.getClass());//class java.util.ArrayList
        System.out.println(list2.getClass());//class basic.ListGetClass$1
        System.out.println(list3.getClass());// class basic.ListGetClass$2
        System.out.println(list4.getClass());//class basic.ListGetClass$3

        System.out.println();
        System.out.println(list2.getClass().getSuperclass().getName());//java.util.ArrayList
        System.out.println(list3.getClass().getSuperclass().getName());//java.util.ArrayList
        System.out.println(list4.getClass().getSuperclass().getName());//java.util.ArrayList

        System.out.println(list1.getClass() == list2.getClass());//false
        System.out.println(list1.getClass() == list3.getClass());//false
        System.out.println(list1.getClass() == list4.getClass());//false
        System.out.println(list2.getClass() == list3.getClass());//false
        System.out.println(list2.getClass() == list4.getClass());//false
        System.out.println(list3.getClass() == list4.getClass());//false
    }
}
