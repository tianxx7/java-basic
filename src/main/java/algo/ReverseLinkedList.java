package algo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author labvi
 * @version 1.0.0
 */
public class ReverseLinkedList<T> {
    private void reverse(LinkedList<T> list){
        Stack<T> stack = new Stack<>();
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T next = iterator.next();
            stack.push(next);
        }
        list.clear();
        while (!stack.empty()){
            list.add(stack.pop());
        }
        list.forEach(System.out::println);
    }
    public static void main(String[] args) {
        ReverseLinkedList<Integer> list = new ReverseLinkedList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        list.reverse(linkedList);
    }
}
