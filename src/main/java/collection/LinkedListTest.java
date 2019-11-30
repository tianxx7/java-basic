package collection;

import org.junit.Test;

public class LinkedListTest {

    /*
     * LinkedList模拟一个堆栈或队列的数据结构
     * */
    @Test
    public void linkedListToQueue() {
        //模拟栈
        MyQueue<String> strings = new MyQueue<>();
        strings.push("1");
        strings.push("2");
        strings.push("3");
        while (!strings.isEmpty()){
            System.out.println(strings.pop());
        }
    }
}
