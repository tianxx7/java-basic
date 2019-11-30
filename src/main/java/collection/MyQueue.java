package collection;

import java.util.LinkedList;

/*
 * LinkedList模拟队列,栈
 * */
public class MyQueue<T> {
    private LinkedList<T> queue;

    public MyQueue(){
        queue = new LinkedList<T>();
    }

    public void push(T obj){
        queue.addLast(obj);
    }

    public T pop(){
        //return queue.removeFirst();//队列
       return queue.removeLast(); // 栈
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
