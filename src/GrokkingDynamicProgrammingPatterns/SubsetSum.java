package GrokkingDynamicProgrammingPatterns;

public class SubsetSum {
    /*
    Problem Statement #
Given a set of positive numbers, determine if there exists a subset whose sum is equal to a given number ‘S’.

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
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 7};
        int k = 6;
        System.out.println(SubsetSumBruteForce.SubsetSum(nums, k));
    }
}

class SubsetSumBruteForce {
    public static boolean SubsetSum(int[] nums, int k) {
        return recursive(nums, k, 0);
    }


    public static boolean recursive(int[] nums, int k, int currentIndex) {

        if (k == 0)
            return true;
        if (nums.length == 0 || currentIndex >= nums.length) {
            return false;
        }

        if (nums[currentIndex] <= k) {
            if (recursive(nums, k - nums[currentIndex], currentIndex + 1)) {
                return true;
            }
        }
        return recursive(nums, k, currentIndex + 1);
    }
}

class SubsetSumBottomupDynamicProgramming {
    /*
    The above solution has time and space complexity of O(N*S)O(N∗S), where ‘N’ represents total numbers and ‘S’ is the required sum.
     */
    public static boolean SubsetSum(int[] nums, int sum) {

        int n = nums.length;

        boolean[][] dp = new boolean[n][sum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 0; i <= sum; i++) {
            dp[0][i] = (nums[0] == i) ? true : false;
        }

        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                if (dp[i - 1][s])
                    dp[i][s] = dp[i - 1][s];
                else if (s >= nums[i]) {
                    dp[i][s] = dp[i - 1][s - nums[i]];
                }

            }
        }
        return dp[nums.length - 1][sum];
    }


}