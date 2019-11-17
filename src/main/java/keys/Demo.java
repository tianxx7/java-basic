package keys;


/*
 * static finally关键字
 * */
public class Demo {



    public Demo(){
        System.out.println("构造方法");
    }
    /*
    * 代码块优先于构造方法先执行
    * */
    {
        System.out.println("代码块");
    }


    public int testFinally() {
        int re = 5;
        try {
            return re;
        }finally {
            re = 6;
            return re;
        }
    }


    public static void main(String[] args) {
        Test obj  = null;

        Demo demo = new Demo();
        demo.getClass();
        System.out.println(Demo.class.isInstance(demo));
        System.out.println(demo.testFinally());
        /*
        * foo called
        * return called
        * */
        System.out.println(obj.foo());
    }
}

class Test{
    public static String foo(){
        System.out.println("foo called");
        return "return called";
    }
}
