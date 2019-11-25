package serializable;

import serializable.AdapterPerson;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/*
        序列化过程控制台打印
        Peron writeReplace
        Adapter writeObject
        Adapter readObject
        AdapterPerson{name='田新兴', age=24}
* 实现了writeReplace的序列化类就不要再writeObject,因为该类的writeObject方法就不会被调用,实现writeObject的返回对象
    必须是可序列化的对象,通过writeReplace序列化替换的对象在反序列化中无论实现那个方法都是无法恢复原对象,就是说
    通过ObjectInputStream读取的对象是能是被替换的对象
    所以writeObject只和readObject配合使用,一旦实现writeReplace在写入时进行替换就不再需要writeObject和readObject了,
    故替换就是彻底的自定义
* */
public class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
    *
    * */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        System.out.println("Person writeObject");
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        System.out.println("Person readObject");
    }

    private Object writeReplace(){
        System.out.println("Peron writeReplace");
        return new AdapterPerson(name,age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
