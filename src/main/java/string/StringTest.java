package string;

import org.junit.Test;

import java.nio.charset.Charset;

public class StringTest {

    @Test
    public void testString1(){
        String s1 = "abc";
        StringBuffer s2 = new StringBuffer(s1);
        System.out.println(s1.equals(s2));//false
        //equals不会做类型转换,一旦类型不一致直接返回false
        //基本类型的包装类equals方法会使用instanceof判断是否是该类型,不然直接false
    }
    /*
    * 将 GB2312 编码的字符串转换为 ISO-8859-1 编码的字符串？
    * */
    @Test
    public void testString2(){
        String s1 = "你好";
        String s2 = new String(s1.getBytes(Charset.forName("GB2312")),Charset.forName("ISO-8859-1"));
        System.out.println(s1);
        System.out.println(s2);
    }

    static final char[] value = new char[10];

    @Test
    public void testString_is_final(){
        for (int i = 0; i < value.length; i++) {
            value[i] = (char)(i+32);
        }
        for (int i = 0; i < value.length; i++) {
            System.out.println(value[i]);
        }

        value[9] = 98;
        for (int i = 0; i < value.length; i++) {
            System.out.println(value[i]);
        }
    }

    @Test
    public void testString(){
        String s1 = "abc";
        System.out.println(s1);
    }
}
