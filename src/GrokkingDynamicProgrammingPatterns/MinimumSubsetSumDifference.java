package GrokkingDynamicProgrammingPatterns;

/*
Problem Statement #
Given a set of positive numbers, partition the set into two subsets with a minimum difference between their subset sums.

Example 1: #
Input: {1, 2, 3, 9}
Output: 3
Explanation: We can partition the given set into two subsets where minimum absolute difference
between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} & {9}.
Example 2: #
Input: {1, 2, 7, 1, 5}
Output: 0
Explanation: We can partition the given set into two subsets where minimum absolute difference
between the sum of number is '0'. Following are the two subsets: {1, 2, 5} & {7, 1}.
Example 3: #
Input: {1, 3, 100, 4}
Output: 92
Explanation: We can partition the given set into two subsets where minimum absolute difference
between the sum of numbers is '92'. Here are the two subsets: {1, 3, 4} & {100}.


 */
public class MinimumSubsetSumDifference {
    public static void main(String[] args) {

        int[] num = {1, 2, 3, 9};
        //System.out.println(MinimumSubsetSumDifferenceBruteForce.canPartition(num));
        System.out.println(MinimumSubsetSumDifferenceBottomupDynamicProgramming.canPartition(num));
    }

}

class MinimumSubsetSumDifferenceBruteForce {

    public static int canPartition(int[] num) {
        return canPartitionRecursive(num, 0, 0, 0);
    }

    private static int canPartitionRecursive(int[] num, int currentIndex, int sum1, int sum2) {
        if (currentIndex == num.length) {
            return Math.abs(sum1 - sum2);
        }

        int diff1 = canPartitionRecursive(num, currentIndex + 1, sum1 + num[currentIndex], sum2);
        int diff2 = canPartitionRecursive(num, currentIndex + 1, sum1, sum2 + num[currentIndex]);

        System.out.println("diff1:" + diff1 + " diff2:" + diff2 + " Math.min(diff1, diff2):" + Math.min(diff1, diff2));
        return Math.min(diff1, diff2);
    }
}

class MinimumSubsetSumDifferenceTopdownDynamicProgrammingwithMemoization {

    public static int canPartition(int[] num) {
        int sum = 0;
        for (int n : num) {
            sum += n;
        }
        Integer[][] dp = new Integer[num.length][sum + 1];

        return canPartitionRecursive(dp, num, 0, 0, 0);
    }

    private static int canPartitionRecursive(Integer[][] dp, int[] num, int currentIndex, int sum1, int sum2) {
        if (currentIndex == num.length) {
            return Math.abs(sum1 - sum2);
        }

        if (dp[currentIndex][sum1] == null) {
            int diff1 = canPartitionRecursive(dp, num, currentIndex + 1, sum1 + num[currentIndex], sum2);
            int diff2 = canPartitionRecursive(dp, num, currentIndex + 1, sum1, sum2 + num[currentIndex]);
            dp[currentIndex][sum1] = Math.min(diff1, diff2);
        }
        return dp[currentIndex][sum1];
    }
}

class MinimumSubsetSumDifferenceBottomupDynamicProgramming {

    public static int canPartition(int[] nums) {

        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }


        boolean[][] dp = new boolean[n][sum/2 + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int s = 1; s <= sum/2; s++) {
            dp[0][s] = nums[0] == s ? true : false;
        }

        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum/2; s++) {
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= nums[i]) {
                    dp[i][s] = dp[i - 1][s - nums[i]];
                }
            }
        }

        int sum1 = 0;

        for (int i = sum/2; i >= 0; i--) {
            if (dp[n - 1][i]) {
                sum1 = i;
                break;
            }
        }

        int sum2 = sum - sum1;
        return Math.abs(sum2 - sum1);
    }

}