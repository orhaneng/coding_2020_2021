package IntroductionToAlgorithms;

//https://leetcode.com/problems/maximum-subarray/

import java.util.Arrays;

public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    public static int maxSubArray(int[] nums) {
        return  findMaxSubarray(nums,0,nums.length-1)[2];
    }

    public static int[] findMaxSubarray(int[] A, int low, int high) {

        if (high == low)
            return new int[]{low, high, A[low]};
        else {
            int mid = (low + high) / 2;
            int[] left = findMaxSubarray(A, low, mid);
            int[] right = findMaxSubarray(A, mid + 1, high);
            int[] cross = findMaxCrossingSubarray(A, low, mid, high);

            if (left[2] >= right[2] && left[2] >= cross[2]) {
                return left;
            }else if (right[2] >= left[2] && right[2] >= cross[2]) {
                return right;
            }else{
                return cross;
            }
        }
    }

    public static int[] findMaxCrossingSubarray(int[] A, int low, int mid, int high) {
        int left_sum = Integer.MIN_VALUE;
        int max_left = mid;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum = sum + A[i];
            if (sum > left_sum) {
                left_sum = sum;
                max_left = i;
            }
        }
        int right_sum = Integer.MIN_VALUE;
        int max_right = mid + 1;
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum = sum + A[j];
            if (sum > right_sum) {
                right_sum = sum;
                max_right = j;
            }
        }

        int[] res = {max_left, max_right, left_sum + right_sum};
        return res;
    }
}
