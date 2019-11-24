package basic;


import java.io.Serializable;

public class Singleton implements Serializable {
    private Singleton(){}

    private static final Singleton INSTANCE = new Singleton();
    public static Singleton getInstance(){
        return INSTANCE;
    }

    private Object readResolve() {
        System.out.println("Singleton readResolve");
        return INSTANCE;
    }
}
