package serializable;

import java.io.Serializable;

/*
 * 父类实现序列化,子类禁止序列化
 * */
public class SuperSerializableClass implements Serializable {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "SuperSerializableClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
