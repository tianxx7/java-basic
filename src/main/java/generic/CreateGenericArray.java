package generic;

import java.lang.reflect.Array;

/*
 * 优雅创建泛型数组
 * 使用反射来初始化泛型数组是优雅实现,因为泛型类T在运行时才能被确定下来,我们能创建泛型数组必然是在
 * Java运行时想办法,而运行时能起作用的技术最好的就是反射了
 * */
public class CreateGenericArray<T> {
    private T[] array;

    public CreateGenericArray(Class<T> type,int size){
        array = (T[])Array.newInstance(type, size);
    }

    public void put(int index,T item){
        array[index] = item;
    }
    public T get(int index){
        return array[index];
    }

    public T[] create(){
        return array;
    }

    public static void main(String[] args) {
        CreateGenericArray<Integer> array = new CreateGenericArray<>(Integer.class, 10);
        Integer[] integers = array.create();

    }
}
