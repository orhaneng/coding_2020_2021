package GrokkingCodingPatterns.SlidingWindow;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/maximum-average-subarray-i/solution/

public class AverageOfAllContiguousSubarrays {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        Arrays.stream(func2(arr, 5)).forEach(System.out::println);

    }

    public static List<Double> func(int[] arr, int k) {
        /*
        TIME O(N*K)
         */
        List<Double> res = new ArrayList<>();
        for (int i = 0; i < arr.length - k; i++) {
            double sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            res.add(sum / k);
        }
        return res;
    }

    public static double[] func2(int[] arr, int k) {
        /*
        TIME O(N)
         */
        double[] res = new double[arr.length - k + 1];
        double windowsum=0;
        int windowbegin = 0;
        for (int windowend = 0; windowend < arr.length; windowend++) {
            windowsum += arr[windowend];

            if (windowend >= k - 1) {
                res[windowbegin] = windowsum / k;
                windowsum -= arr[windowbegin];
                windowbegin++;
            }
        }
        return res;
    }
}
