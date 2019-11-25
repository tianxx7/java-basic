package serializable;

import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * 子类禁止序列化
 * */
public class SubClass extends SuperSerializableClass {
    private void readObject(ObjectInputStream in) throws NotSerializableException {
        throw new NotSerializableException("");
    }
    private void writeObject(ObjectOutputStream out) throws NotSerializableException {
        throw new NotSerializableException("");
    }
    private void readObjectNoData() throws NotSerializableException {
        throw new NotSerializableException("");
    }
}
