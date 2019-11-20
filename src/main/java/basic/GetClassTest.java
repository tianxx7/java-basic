package basic;

import java.util.Date;

/*
* getClass方法测试
*
* */
public class GetClassTest extends Date{
    public void test(){
        System.out.println(super.getClass().getName());
    }

    public static void main(String[] args) {
        GetClassTest getClassTest = new GetClassTest();
        getClassTest.test();//basic.GetClassTest
        /*
        * 因为getClass()方法是final,无法被重写,
        * 子类无法覆盖,相当于调用父类的getClass方法
        * getClass方法来源于object类,且其返回对象在运行时的类型
        * 如果想得到父类的名称应该如下
        * */

        //java.util.Date
        System.out.println(getClassTest.getClass().getSuperclass().getName());

    }
}
