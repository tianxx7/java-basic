package basic;

public class TryCatchFinallyTest {

    private static String reString(){
        try {
            return "try";
        } catch (Exception e){
            return "exception";
        } finally {
            return "finally";
        }
    }

    public static void main(String[] args) {
        System.out.println(reString());//finally
    }
}
