package GrokkingDynamicProgrammingPatterns;

import java.util.HashMap;
import java.util.Map;

/*
Problem Statement #
Given a number sequence, find the increasing subsequence with the highest sum. Write a method that returns the highest sum.

Example 1:

Input: {4,1,2,6,10,1,12}
Output: 32
Explanation: The increaseing sequence is {4,6,10,12}.
Please note the difference, as the LIS is {1,2,6,10,12} which has a sum of '31'.
Example 2:

Input: {-4,10,3,7,15}
Output: 25
Explanation: The increaseing sequences are {10, 15} and {3,7,15}.
 */
public class MaximumSumIncreasingSubsequence {

}

class MaximumSumIncreasingSubsequenceBruteForce {
    public int findMSIS(int[] nums) {
        return (helper(nums, 0, -1, 0));
    }

    public static int helper(int[] nums, int currentIndex, int previousIndex, int sum) {
        if (currentIndex == nums.length)
            return sum;

        int s1 = sum;
        if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex]) {
            s1 = helper(nums, currentIndex + 1, currentIndex, sum + nums[currentIndex]);
        }
        int s2 = helper(nums, currentIndex + 1, previousIndex, sum);
        return Math.max(s1, s2);
    }
}

class MaximumSumIncreasingSubsequenceTopdownDynamicProgrammingwithMemoization {
    public int findMSIS(int[] nums) {
        Map<String, Integer> dp = new HashMap<>();

        return (helper(dp, nums, 0, -1, 0));
    }

    public static int helper(Map<String, Integer> dp, int[] nums, int currentIndex, int previousIndex, int sum) {
        if (currentIndex == nums.length)
            return sum;

        String key = currentIndex + "-" + previousIndex + "-" + sum;
        if (!dp.containsKey(key)) {
            int s1 = sum;
            if (previousIndex == -1 || nums[currentIndex] > nums[previousIndex]) {
                s1 = helper(dp, nums, currentIndex + 1, currentIndex, sum + nums[currentIndex]);
            }
            int s2 = helper(dp, nums, currentIndex + 1, previousIndex, sum);
            dp.put(key, Math.max(s1, s2));
        }
        return dp.get(key);
    }
}

class MaximumSumIncreasingSubsequenceBottomupDynamicProgramming {

    //The time complexity of the above algorithm is O(n^2)O(n
    //​2
    //​​ ) and the space complexity is O(n)O(n).
    public int findMSIS(int[] nums) {

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + nums[i]) {
                    dp[i] = dp[j] + nums[i];
                }
                maxSum = Math.max(maxSum, dp[i]);
            }
        }
        return maxSum;
    }


}