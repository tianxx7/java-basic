package collection;

import java.io.Serializable;

public class InfoBean2 implements Serializable {
    private String name;

    private int age;

    public InfoBean2() {
    }

    public InfoBean2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
