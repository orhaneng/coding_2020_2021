package GrokkingCodingPatterns.KnapsackDynamicProgramming;

public class MinimumSubsetSumDifference {
    /*
    Problem Statement #
Given a set of positive numbers, partition the set into two subsets with minimum difference between their subset sums.

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

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 9};
        //System.out.println(MinimumSubsetSumDifferenceBruteForce.canPartition(nums));
        //System.out.println(MinimumSubsetSumDifferenceTopDownDynamicMemoization.canPartition(nums));
        System.out.println(MinimumSubsetSumDifferenceBottomUpDynamicProgramming.canPartition(nums));


    }

}

class MinimumSubsetSumDifferenceBruteForce {

    /*
    Time and Space complexity #
Because of the two recursive calls, the time complexity of the above algorithm is exponential O(2^n)O(2
​n
​​ ), where ‘n’ represents the total number. The space complexity is O(n)O(n) which is used to store the recursion stack.
     */
    public static int canPartition(int[] nums) {
        return canPartitionRecursive(nums, 0, 0, 0);
    }

    public static int canPartitionRecursive(int[] nums, int currentIndex, int sum1, int sum2) {

        if (currentIndex == nums.length) {
            return Math.abs(sum1 - sum2);
        }

        int diff1 = canPartitionRecursive(nums, currentIndex + 1, sum1 + nums[currentIndex], sum2);

        int diff2 = canPartitionRecursive(nums, currentIndex + 1, sum1, sum2 + nums[currentIndex]);

        return Math.min(diff1, diff2);
    }
}

class MinimumSubsetSumDifferenceTopDownDynamicMemoization {

    /*
    Time and Space complexity #
Because of the two recursive calls, the time complexity of the above algorithm is exponential O(2^n)O(2
​n
​​ ), where ‘n’ represents the total number. The space complexity is O(n)O(n) which is used to store the recursion stack.
     */
    public static int canPartition(int[] nums) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        Integer[][] dp = new Integer[nums.length][sum + 1];

        return canPartitionRecursive(dp, nums, 0, 0, 0);
    }

    public static int canPartitionRecursive(Integer[][] dp, int[] nums, int currentIndex, int sum1, int sum2) {

        if (currentIndex == nums.length) {
            return Math.abs(sum1 - sum2);
        }

        if (dp[currentIndex][sum1] == null) {
            int diff1 = canPartitionRecursive(dp, nums, currentIndex + 1, sum1 + nums[currentIndex], sum2);

            int diff2 = canPartitionRecursive(dp, nums, currentIndex + 1, sum1, sum2 + nums[currentIndex]);

            dp[currentIndex][sum1] = Math.min(diff1, diff2);
        }

        return dp[currentIndex][sum1];
    }
}

class MinimumSubsetSumDifferenceBottomUpDynamicProgramming {

    /*
Time and Space complexity #
The above solution has the time and space complexity of O(N*S)O(N∗S), where ‘N’
represents total numbers and ‘S’ is the total sum of all the numbers.  */
    public static int canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        int n = nums.length;

        boolean[][] dp = new boolean[n][sum / 2 + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int s = 0; s <= sum / 2; s++) {
            dp[0][s] = (nums[0] == s ? true : false);
        }

        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum / 2; s++) {
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (s >= nums[i]) {
                    dp[i][s] = dp[i - 1][s - nums[i]];
                }
            }
        }

        int sum1 = 0;
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[n - 1][i] == true) {
                sum1 = i;
                break;
            }
        }

        int sum2 = sum - sum1;
        return Math.abs(sum2 - sum1);
    }
}