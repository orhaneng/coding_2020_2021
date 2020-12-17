package GrokkingCodingPatterns.SlidingWindow;

//
public class MaximumSumSubarrayofSizeK {
    public static void main(String[] args) {

        System.out.println(maximumSumSubarrayofSizeK(new int[]{2, 3, 4, 1, 5}, 2));
    }

    public static int maximumSumSubarrayofSizeK(int[] arr, int k) {
        /*
        TIME O(N)
        SPACE O(1)
         */
        int max = 0;
        int sum = 0;
        int begin = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k - 1) {
                max = Math.max(sum, max);
                sum -= arr[begin++];
            }
        }
        return max;
    }
}
