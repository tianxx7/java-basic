package clone;

import serializable.InfoBean2;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * 关于集合clone
 * */
public class Copy {
    static ArrayList<InfoBean> srcList = new ArrayList<>();
    static ArrayList<InfoBean2> srcList2 = new ArrayList<>();
    static {
        srcList.add(new InfoBean("123", 1));
        srcList.add(new InfoBean("456", 1));
        srcList.add(new InfoBean("789", 1));
        srcList.add(new InfoBean("100", 1));

        srcList2.add(new InfoBean2("123", 1));
        srcList2.add(new InfoBean2("456", 1));
        srcList2.add(new InfoBean2("789", 1));
        srcList2.add(new InfoBean2("100", 1));
    }

    /*
        浅clone  clone方法
        是否重写clone不影响
    */
    @Test
    public void srcClone() {
        List<InfoBean> clone = (List<InfoBean>) srcList.clone();
        //全部为true
        for (int i = 0; i < srcList.size(); i++) {
            System.out.println(clone.get(i) == srcList.get(i));
        }
    }

    /*
     * add浅复制
     * 是否重写不影响
     * */
    @Test
    public void forClone() {
        ArrayList<InfoBean> destList = new ArrayList<>(srcList.size());
        for (InfoBean bean : srcList) {
            destList.add(bean);
        }
        for (int i = 0; i < srcList.size(); i++) {
            System.out.println(destList.get(i) == srcList.get(i));
        }
    }

    /*
     *addAll浅复制
     * 是否重写clone不影响
     * */
    @Test
    public void addAllClone() {
        ArrayList<InfoBean> destList = new ArrayList<>(srcList.size());
        destList.addAll(srcList);
        for (int i = 0; i < srcList.size(); i++) {
            System.out.println(destList.get(i) == srcList.get(i));
        }
    }

    /*
     * 构造方法浅clone
     * 是否重写clone不影响
     * */
    @Test
    public void constructor() {
        ArrayList<InfoBean> destList = new ArrayList<>(srcList);
        for (int i = 0; i < srcList.size(); i++) {
            System.out.println(destList.get(i) == srcList.get(i));
        }
    }

    /*
     * system.copy 浅复制
     * InfoBean没有重写clone方法
     * 对于InfoBean是否重写clone方法,System.arratcopy都是浅复制
     * */
    @Test
    public void sysCopy() {
        InfoBean[] srcBeans = srcList.toArray(new InfoBean[0]);
        InfoBean[] destBeans = new InfoBean[srcBeans.length];
        System.arraycopy(srcBeans, 0, destBeans, 0, srcBeans.length);
        for (int i = 0; i < srcBeans.length; i++) {
            System.out.println(destBeans[i] == srcBeans[i]);
        }
    }

    /*
     * InfoBean实现Cloneable接口,重写clone方法
     *
     * */
    @Test
    public void deepClone() throws CloneNotSupportedException {
        List<InfoBean> destList = new ArrayList<>(srcList.size());
        for (int i = 0; i < srcList.size(); i++) {
            InfoBean bean = srcList.get(i);
            destList.add((InfoBean) bean.clone());
        }
        for (int i = 0; i < srcList.size(); i++) {
            System.out.println(destList.get(i) == srcList.get(i));
        }
    }

   /*
     序列化深度clone
   */
    @Test
    public void deepClone2() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream obOut = new ObjectOutputStream(byteOut);
        obOut.writeObject(srcList2);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream obIn = new ObjectInputStream(byteIn);
        List<InfoBean2> destList = (List<InfoBean2>)obIn.readObject();
        for (int i = 0; i < srcList.size(); i++) {
            System.out.println(destList.get(i) == srcList2.get(i));
        }
    }
}
