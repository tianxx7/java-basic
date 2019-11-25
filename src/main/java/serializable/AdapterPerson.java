package serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AdapterPerson implements Serializable {
    private String name;
    private int age;

    public AdapterPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        System.out.println("Adapter writeObject");
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        System.out.println("Adapter readObject");
    }


    @Override
    public String toString() {
        return "AdapterPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
