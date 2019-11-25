package serializable;

import java.io.*;
/*
* Externalizable例子
* */
public class SerializablePerson2 implements Externalizable {
    private String name;
    private int age;

    /*
    * 实现Externalizable必须有默认的构造函数
    * */
    public SerializablePerson2() {
    }

    public SerializablePerson2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "SerializableTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
       /* out.writeUTF(name);
        out.writeInt(age);*/
        out.writeObject(name);
        out.writeObject(age);
    }

    /*
    * 与上面顺序一致,不然会有UTFDataFormatException
    *ClassCastException
     * */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        /*this.name = in.readUTF();
        this.age = in.readInt();*/
        this.name = (String)in.readObject();
        this.age = (int)in.readObject();


    }
}
