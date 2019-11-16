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

    /*
    * 测试String的subString方法
    * index == 0 直接返回当前对象
    * 其他会new String()
    * 对于toUpperCase一样
    * */
    @Test
    public void testSubString(){
        String str1 = "123";
        System.out.println("123" == str1.substring(0));
        System.out.println("23" == str1.substring(1));
    }

    /*
    * 反转字符串,string本身没有反转方法,需要StringBuilder活StringBuffer
    * 反转操作的是原始对象的value数组,也就是原始对象字符串反转了
    * */
    @Test
    public void reverseString(){
        String s1 = "123";
        System.out.println(new StringBuilder(s1).reverse().toString());
        System.out.println(new StringBuffer(s1).reverse().toString());
        System.out.println(reverse(s1));
    }

    /*
    * 炫技能
    * */
    public static String reverse(String str){
        if (str == null || str.length() <= 0) {
            return str;
        }
        return reverse(new String(str.substring(1))) + str.charAt(0);
    }

    /*
     * 检查字符串是否是回文
     * */
    @Test
    public void isPalindrome() {
        String str = "12321";
        if (str == null) {
            System.out.println(false);
        }
        StringBuilder strBuilder = new StringBuilder(str);
        strBuilder.reverse();
        System.out.println(strBuilder);
        System.out.println(strBuilder.toString().equals(str));
    }
}
