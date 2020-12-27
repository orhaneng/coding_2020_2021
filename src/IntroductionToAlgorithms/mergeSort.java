package IntroductionToAlgorithms;

import java.util.Arrays;

public class mergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 4, 6, 1, 3};
        mergeSort(nums, 0, nums.length - 1);

        Arrays.stream(nums).forEach(System.out::println);
    }


    //https://www.reddit.com/r/algorithms/comments/hdrv6t/learning_algs_with_clrs_book_and_i_need_an_answer/

    public static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;


        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i ];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = A[q + i + 1];
        }

        int i = 0;
        int j = 0;


        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }
}
