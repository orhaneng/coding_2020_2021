package GrokkingDynamicProgrammingPatterns;

public class LongestAlternatingSubsequence {
    /*
    Problem Statement #
Given a number sequence, find the length of its Longest Alternating Subsequence (LAS).
A subsequence is considered alternating if its elements are in alternating order.

A three element sequence (a1, a2, a3) will be an alternating sequence
if its elements hold one of the following conditions:

{a1 > a2 < a3 } or { a1 < a2 > a3}.
Example 1:

Input: {1,2,3,4}
Output: 2
Explanation: There are many LAS: {1,2}, {3,4}, {1,3}, {1,4}
Example 2:

Input: {3,2,1,4}
Output: 3
Explanation: The LAS are {3,2,4} and {2,1,4}.
Example 3:

Input: {1,3,2,4}
Output: 4
Explanation: The LAS is {1,3,2,4}.

     */
}

class LongestAlternatingSubsequenceBruteForce {
    public int findLASLength(int[] nums) {
        return Math.max(helper(nums, -1, 0, true),
                helper(nums, -1, 0, false));
    }

    public int helper(int[] nums, int prevIndex, int curIndex, boolean asc) {
        if (curIndex == nums.length)
            return 0;

        int c1 = 0;
        if (asc) {
            if (prevIndex == -1 || nums[prevIndex] < nums[curIndex])
                c1 = 1 + helper(nums, curIndex, curIndex + 1, !asc);
        } else {
            if (prevIndex == -1 || nums[prevIndex] > nums[curIndex]) {
                c1 = 1 + helper(nums, curIndex, curIndex + 1, !asc);
            }
        }

        int c2 = helper(nums, prevIndex, curIndex + 1, asc);
        return Math.max(c1, c2);
    }
}

class LongestAlternatingSubsequenceTopdownDynamicProgrammingwithMemoization {
    public int findLASLength(int[] nums) {
        Integer[][][] dp = new Integer[nums.length][nums.length][2];
        return Math.max(helper(dp, nums, -1, 0, true),
                helper(dp, nums, -1, 0, false));
    }

    public int helper(Integer[][][] dp, int[] nums, int prevIndex, int curIndex, boolean asc) {
        if (curIndex == nums.length)
            return 0;

        if(dp[prevIndex+1][curIndex][asc?1:0]==null) {
            int c1 = 0;
            if (asc) {
                if (prevIndex == -1 || nums[prevIndex] < nums[curIndex])
                    c1 = 1 + helper(dp, nums, curIndex, curIndex + 1, !asc);
            } else {
                if (prevIndex == -1 || nums[prevIndex] > nums[curIndex]) {
                    c1 = 1 + helper(dp, nums, curIndex, curIndex + 1, !asc);
                }
            }

            int c2 = helper(dp, nums, prevIndex, curIndex + 1, asc);
            dp[prevIndex+1][curIndex][asc?1:0]=  Math.max(c1, c2);
        }
        return dp[prevIndex+1][curIndex][asc?1:0];
    }
}

class LongestAlternatingSubsequenceBottomupDynamicProgramming{

    //The time complexity of the above algorithm is O(n^2)O(n
    //​2
    //​​ ) and the space complexity is O(n)O(n).
    public int findLASLength(int[] nums) {
        if(nums.length == 0) return 0;
        //dp[i][0] = stores the LAS ending at 'i' such that the last two elements are in ascending order
        //dp[i][1] = stores the LAS ending at 'i' such that the last two elements are in descending order
        int[][] dp = new int[nums.length][2];
        int maxLength = 1;
        for(int i=0; i < nums.length; i++) {
            // every single element can be considered as LAS of length 1
            dp[i][0] = dp[i][1] = 1;
            for(int j=0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    // if nums[i] is BIGGER than nums[j] then we will consider the LAS ending at 'j' where the
                    // last two elements were in DESCENDING order
                    dp[i][0] = Math.max(dp[i][0], 1 + dp[j][1]);
                    maxLength = Math.max(maxLength, dp[i][0]);
                } else if (nums[i] != nums[j]) { // if the numbers are equal don't do anything
                    // if nums[i] is SMALLER than nums[j] then we will consider the LAS ending at 'j' where the
                    // last two elements were in ASCENDING order
                    dp[i][1] = Math.max(dp[i][1], 1 + dp[j][0]);
                    maxLength = Math.max(maxLength, dp[i][1]);
                }
            }
        }
        return maxLength;
    }
}