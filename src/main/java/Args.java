/*
 * 变长参数
 * */
public class Args {
    private static void run(String str,Integer... args){
        System.out.println("integer...");
    }

    private static void run(String str,String... args){
        System.out.println("string...");
    }

    public static void main(String[] args) {
        //编译报错,因为不知道调用那个方法
        //run("hello");
        //run("hello",null);

        //调用run(String str,String.. args)
        String str = "hello";
        String[] strings =null;
        run(str, strings);
    }

}

