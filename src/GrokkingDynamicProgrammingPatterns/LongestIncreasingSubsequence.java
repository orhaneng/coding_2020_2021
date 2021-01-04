package GrokkingDynamicProgrammingPatterns;

//https://leetcode.com/problems/longest-increasing-subsequence/

/*
Problem Statement #
Given a number sequence, find the length of its Longest Increasing Subsequence (LIS). In an increasing subsequence, all the elements are in increasing order (from lowest to highest).

Example 1:

Input: {4,2,3,6,10,1,12}
Output: 5
Explanation: The LIS is {2,3,6,10,12}.
Example 1:

Input: {-4,10,3,7,15}
Output: 4
Explanation: The LIS is {-4,3,7,15}.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

    }
}

class LongestIncreasingSubsequenceBruteForce {
    /*
    \The time complexity of the above algorithm is exponential O(2^n)O(2
​n
​​ ), where ‘n’ is the lengths of the input array. The space complexity is O(n)O(n) which is used to store the recursion stack.
     */
    public int lengthOfLIS(int[] nums) {
        return helper(nums, 0, -1);
    }


    public static int helper(int[] nums, int current, int previous) {
        if (current == nums.length)
            return 0;

        int c1 = 0;
        if (previous != -1 && nums[current] > nums[previous]) {
            c1 = 1 + helper(nums, current + 1, current);
        }
        int c2 = helper(nums, current + 1, previous);

        return Math.max(c1, c2);
    }
}

class LongestIncreasingSubsequenceTopdownDynamicProgrammingwithMemoization {
    /*
What is the time and space complexity of the above solution? Since our memoization array dp[nums.length()][nums.length()] stores the results for all the subproblems, we can conclude that we will not have more than N*NN∗N subproblems (where ‘N’ is the length of the input sequence). This means that our time complexity will be O(N^2)O(N
​2
​​ ).

The above algorithm will be using O(N^2)O(N
​2
​​ ) space for the memoization array. Other than that we will use O(N)O(N) space for the recursion call-stack. So the total space complexity will be O(N^2 + N)O(N
​2
​​ +N), which is asymptotically equivalent to O(N^2)O(N
​2
​​ ).


     */
    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length + 1];
        return helper(dp, nums, 0, -1);
    }


    public static int helper(Integer[][] dp, int[] nums, int current, int previous) {
        if (current == nums.length)
            return 0;

        if (dp[current][previous + 1] == null) {
            int c1 = 0;
            if (previous != -1 && nums[current] > nums[previous]) {
                c1 = 1 + helper(dp, nums, current + 1, current);
            }
            int c2 = helper(dp, nums, current + 1, previous);

            dp[current][previous + 1] = Math.max(c1, c2);
        }
        return dp[current][previous + 1];

    }
}

class LongestIncreasingSubsequenceBottomupDynamicProgramming {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        return maxLength;
    }
}