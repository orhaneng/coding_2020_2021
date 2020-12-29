package GrokkingCodingPatterns.KnapsackDynamicProgramming;

//
/*
Problem Statement #
Given a set of positive numbers, determine if a subset exists whose sum is equal to a given number ‘S’.

Example 1: #
Input: {1, 2, 3, 7}, S=6
Output: True
The given set has a subset whose sum is '6': {1, 2, 3}
Example 2: #
Input: {1, 2, 7, 1, 5}, S=10
Output: True
The given set has a subset whose sum is '10': {1, 2, 7}
Example 3: #
Input: {1, 3, 4, 8}, S=6
Output: False
The given set does not have any subset whose sum is equal to '6'.


 */
public class SubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 7};
        // System.out.println(SubsetSumBruteForce.SubsetSum(nums, 60));
        //System.out.println(SubsetSumButtomUpDynamicProgramming.SubsetSum(nums, 6));
        System.out.println(SubsetSumButtomUpDynamicProgrammingSumSpace.SubsetSum(nums, 6));
    }
}


class SubsetSumBruteForce {

    public static boolean SubsetSum(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[i];
                if (sum == k)
                    return true;
            }
        }
        return false;
    }
}

class SubsetSumButtomUpDynamicProgramming {

    /*
    Time and Space complexity #
The above solution has the time and space complexity of O(N*S)O(N∗S), where ‘N’ represents total numbers and ‘S’ is the required sum.

     */

    public static boolean SubsetSum(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][sum + 1];


        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int s = 1; s < sum; s++) {
            dp[0][s] = (nums[0] == s ? true : false);
        }

        for (int i = 1; i < nums.length; i++) {
            for (int s = 1; s <= sum; s++) {
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= nums[i]) {
                    dp[i][s] = dp[i - 1][s - nums[i]];
                }
            }
        }
        return dp[n - 1][sum];
    }
}

class SubsetSumButtomUpDynamicProgrammingSumSpace {

    /*
    Time and Space complexity #
The above solution has the time and  of O(N*S)O(N∗S), where ‘N’ represents total numbers and ‘S’ is the required sum.
Space O(S)

     */

    public static boolean SubsetSum(int[] nums, int sum) {
        int n = nums.length;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int s = 1; s < sum; s++) {
            dp[s] = (nums[0] == s ? true : false);
        }

        for (int i = 1; i < n; i++) {
            for (int s = sum; s >= 0; s--) {
                if (!dp[s] && s >= nums[i]) {
                    dp[s] = dp[s - nums[i]];
                }
            }
        }
        return dp[sum];
    }
}