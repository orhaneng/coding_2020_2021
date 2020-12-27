package IntroductionToAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 4, 6, 1, 3};
        insertioSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void insertioSort(int[] arr) {

        int n = arr.length;

        for (int j = 1; j < n; j++) {
            Arrays.stream(arr).forEach(k -> System.out.print(k+","));
            System.out.println();
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];

                i = i - 1;
            }
            arr[i + 1] = key;
        }
    }
}
