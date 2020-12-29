package GrokkingCodingPatterns.KnapsackDynamicProgramming;

//https://leetcode.com/problems/partition-equal-subset-sum/

import java.util.Arrays;

/*
Problem Statement #
Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both subsets is equal.

Example 1:

Input: {1, 2, 3, 4}
Output: True
Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
Example 2:

Input: {1, 1, 3, 4, 7}
Output: True
Explanation: The given set can be partitioned into two subsets with equal sum: {1, 3, 4} & {1, 7}
Example 3:

Input: {2, 3, 4, 6}
Output: False
Explanation: The given set cannot be partitioned into two subsets with equal sum.


 */
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        //System.out.println(PartitionEqualSubsetSumBruteForce.canPartition(nums));
        //System.out.println(PartitionEqualSubsetSumTopDownDynamicProgrammingMemoization.canPartition(nums));
        System.out.println(PartitionEqualSubsetSumBottomUpDynamicProgramming.canPartition(new int[]{1, 2, 5}));
    }

}


class PartitionEqualSubsetSumBruteForce {

    /*
    Time and Space complexity #
The time complexity of the above algorithm is exponential O(2^n)O(2
​n
​​ ), where ‘n’ represents the total number. The space complexity is O(n)O(n), which will be used to store the recursion stack.
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        if (sum % 2 != 0)
            return false;

        return canPartitionRecursive(nums, sum / 2, 0);
    }

    public static boolean canPartitionRecursive(int[] nums, int sum, int currentIndex) {
        if (sum == 0) return true;

        if (nums.length == 0 || currentIndex >= nums.length) {
            return false;
        }

        if (nums[currentIndex] <= sum) {
            if (canPartitionRecursive(nums, sum - nums[currentIndex], currentIndex + 1))
                return true;
        }

        return canPartitionRecursive(nums, sum, currentIndex + 1);
    }
}

class PartitionEqualSubsetSumTopDownDynamicProgrammingMemoization {

    /*
Time and Space complexity #
The above algorithm has the time and space complexity of O(N*S)O(N∗S), where ‘N’
represents total numbers and ‘S’ is the total sum of all the numbers.  */

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        if (sum % 2 != 0)
            return false;

        Boolean[][] dp = new Boolean[nums.length][(sum / 2) + 1];

        return canPartitionRecursive(dp, nums, sum / 2, 0);
    }

    public static boolean canPartitionRecursive(Boolean[][] dp, int[] nums, int sum, int currentIndex) {
        if (sum == 0) return true;

        if (nums.length == 0 || currentIndex >= nums.length) {
            return false;
        }

        if (dp[currentIndex][sum] == null) {
            if (nums[currentIndex] <= sum) {
                if (canPartitionRecursive(dp, nums, sum - nums[currentIndex], currentIndex + 1)) {
                    dp[currentIndex][sum] = true;
                    return true;
                }
            }
            dp[currentIndex][sum] = canPartitionRecursive(dp, nums, sum, currentIndex + 1);
        }

        return dp[currentIndex][sum];
    }
}

class PartitionEqualSubsetSumBottomUpDynamicProgramming {

    /*
Time and Space complexity #
The above algorithm has the time and space complexity of O(N*S)O(N∗S), where ‘N’
represents total numbers and ‘S’ is the total sum of all the numbers.  */

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums)
            sum += num;

        if (sum % 2 != 0)
            return false;

        sum /= 2;

        boolean[][] dp = new boolean[n][sum + 1];


        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int s = 1; s <= sum; s++) {
            dp[0][s] = nums[0] == s ? true : false;
        }

        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= nums[i]) {
                    dp[i][s] = dp[i - 1][s - nums[i]];
                }
            }
        }

//        for (boolean[] row : dp)
//            System.out.println(Arrays.toString(row));
        return dp[n - 1][sum];
    }
}