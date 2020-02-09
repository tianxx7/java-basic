package algo;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author labvi
 * @version 1.0.0
 */
public class BubbleSort {
    private static void sort(int[] arr){
        if (null != arr && arr.length > 1) {
            for (int i = 0,L = arr.length; i < L; i++) {
                boolean flag = false;
                for (int j = 0; j < L - i - 1; j++) {
                    if (arr[j] > arr[j+1]) {
                        int temp = arr[j+1];
                        arr[j+1] = arr[j];
                        arr[j] = temp;
                        flag = true;
                    }
                }
                if (!flag) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,5,7,9,5,3,2,1,4};
        sort(arr);
        Arrays.stream(arr)
                .forEach(System.out::println);
    }
}
