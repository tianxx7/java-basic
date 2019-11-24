package basic;

import org.junit.Test;

import java.io.*;
/*
*
* */
public class SerializableMain {

    /*
    * 默认序列化的实现
    * 在password不是transient时大小时120字节
    * password 是transient时大小是95字节 123456是6字节
    * 自己写writeObject和readObject方法 大小是105字节
    * */
    @Test
    public void serializableTest() throws IOException, ClassNotFoundException {
        SerializablePerson obj = new SerializablePerson("田新兴", 24,"123456");
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteArray);
        out.writeObject(obj);
        out.close();
        System.out.println(byteArray.size());
        ByteArrayInputStream byteArrayIn = new ByteArrayInputStream(byteArray.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteArrayIn);
        SerializablePerson o = (SerializablePerson)in.readObject();
        System.out.println(o.toString());
    }
    @Test
    public void stringTest(){
        System.out.println("123456".getBytes().length);
    }

    @Test
    public void externalTest() throws IOException, ClassNotFoundException {
        SerializablePerson2 person = new SerializablePerson2("田新兴", 24);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream output = new ObjectOutputStream(outputStream);
        output.writeObject(person);
        output.close();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream in = new ObjectInputStream(inputStream);
        Object o = in.readObject();
        System.out.println(o);
    }

    /*
     * 测试writeReplace方法
     * */
    @Test
    public void writeReplaceTest() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteArray);
        Person person = new Person("田新兴", 24);
        out.writeObject(person);
        out.close();
        /*
        * 前半部分打印是:
        * Peron writeReplace
           Adapter writeObject
        * */

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteArray.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        System.out.println(in.readObject());
        in.close();
       /*
          后半部分打印
        Adapter readObject
        AdapterPerson{name='田新兴', age=24}
       * */
    }

    /*
    * 测试readResolve
    * */
    @Test
    public void singleton_serialization_demo() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteArray);
        Singleton instance = Singleton.getInstance();
        out.writeObject(instance);
        out.close();

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteArray.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        System.out.println(instance == in.readObject());
        in.close();
    }
}
