package collection;

public class Info implements Comparable<Info> {
    public String name;
    public int age;

    public Info(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Info)obj).age == this.age;
    }

    @Override
    public int compareTo(Info o) {
        return o.name.compareTo(this.name);
    }

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
