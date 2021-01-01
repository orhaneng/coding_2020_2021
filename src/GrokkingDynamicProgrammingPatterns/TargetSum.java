package GrokkingDynamicProgrammingPatterns;
//https://leetcode.com/problems/target-sum/

/*
Problem Statement #
Given a set of positive numbers (non zero) and a target sum ‘S’. Each number should be assigned either a ‘+’ or ‘-’ sign.
We need to find out total ways to assign symbols to make the sum of numbers equal to target ‘S’.

Example 1: #
Input: {1, 1, 2, 3}, S=1
Output: 3
Explanation: The given set has '3' ways to make a sum of '1': {+1-1-2+3} & {-1+1-2+3} & {+1+1+2-3}
Example 2: #
Input: {1, 2, 7, 1}, S=9
Output: 2
Explanation: The given set has '2' ways to make a sum of '9': {+1+2+7-1} & {-1+2+7+1}
 */
public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        int S = 1;

        System.out.println(TargetSumBottomUpDynamicProgramming.findTargetSumWays(nums, S));
    }
}


class TargetSumBruteForce {
    /*

     */
    public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, S, 0, 0);
    }

    public int helper(int[] nums, int S, int sum, int currentIndex) {

        if (currentIndex == nums.length) {
            return S == sum ? 1 : 0;
        }

        return helper(nums, S, sum + nums[currentIndex], currentIndex + 1) +
                helper(nums, S, sum - nums[currentIndex], currentIndex + 1);
    }
}

class TargetSumBottomUpDynamicProgramming {
    /*

     */
    public static int findTargetSumWays(int[] nums, int S) {
        int totalSum = 0;

        for (int num : nums)
            totalSum += num;

        if (totalSum < S || (S + totalSum) % 2 == 1)
            return 0;

        return countSubsets(nums, (S + totalSum) / 2);
    }

    public static int countSubsets(int[] nums, int S) {

        int n = nums.length;

        int[][] dp = new int[n][S + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= S; i++) {
            dp[0][i] = (nums[0] == i) ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= S; s++) {

                dp[i][s] = dp[i - 1][s];
                if (s >= nums[i]) {
                    dp[i][s] += dp[i - 1][s - nums[i]];
                }

            }
        }
        printMatrix(dp);
        return dp[nums.length - 1][S];
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4d", matrix[row][col]);
            }
            System.out.println();
        }
    }

}

class TargetSumSpaceOptimizedSolution {
    /*

     */
    public static int findTargetSumWays(int[] nums, int S) {
        int totalSum = 0;

        for (int num : nums)
            totalSum += num;

        if (totalSum < S || (S + totalSum) % 2 == 1)
            return 0;

        return countSubsets(nums, (S + totalSum) / 2);
    }

    public static int countSubsets(int[] nums, int S) {

        int n = nums.length;

        int[] dp = new int[S + 1];

        dp[0] = 1;


        for (int i = 1; i <= S; i++) {
            dp[i] = (nums[0] == i) ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int s = S; s >= 0; s--) {
                if (s >= nums[i]) {
                    dp[s] += dp[s - nums[i]];
                }

            }
        }
        return dp[S];
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4d", matrix[row][col]);
            }
            System.out.println();
        }
    }

}
