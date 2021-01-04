package GrokkingDynamicProgrammingPatterns;

//https://leetcode.com/problems/jump-game-ii/solution/

public class MinimumJumpstoreachtheend {
    /*
    Problem Statement #
Given an array of positive numbers, where each element represents the max number of jumps that can be made forward from that element, write a program to find the minimum number of jumps needed to reach the end of the array (starting from the first element). If an element is 0, then we cannot move through that element.

Example 1:

Input = {2,1,1,1,4}
Output = 3
Explanation: Starting from index '0', we can reach the last index through: 0->2->3->4
Example 2:

Input = {1,1,3,6,9,3,0,1,3}
Output = 4
Explanation: Starting from index '0', we can reach the last index through: 0->1->2->3->8
Let’s first start with a recursive brute-force solution.
     */
}

class MinimumJumpstoreachtheendBruteForce {
    /*
    The time complexity of the above algorithm is O(2^n)O(2
​n
​​ ), where ‘n’ is the size of the input array. The ‘while loop’ can execute a maximum of ‘n’ times (for the case where we can jump to all the steps ahead) and since in each iteration, the function recursively calls itself, therefore, the time complexity is O(2^n)O(2
​n
​​ ). The space complexity is O(n)O(n) which is used to store the recursion stack.

     */
    public int countMinJumps(int[] jumps) {
        return helper(jumps, 0);
    }

    private int helper(int[] jumps, int currentIndex) {
        if (currentIndex == jumps.length - 1)
            return 0;
        if (jumps[currentIndex] == 0) {
            return Integer.MAX_VALUE;
        }

        int totalJumps = Integer.MAX_VALUE;
        int start = currentIndex + 1;
        int end = currentIndex + jumps[currentIndex];

        while (start < jumps.length && start <= end) {
            int minJumps = helper(jumps, start++);
            if (minJumps != Integer.MAX_VALUE) {
                totalJumps = Math.min(totalJumps, minJumps + 1);
            }
        }
        return totalJumps;
    }
}

class MinimumJumpstoreachtheendTopdownDynamicProgrammingwithMemoization {
    /*
     */
    public int countMinJumps(int[] jumps) {
        int[] dp = new int[jumps.length];
        return helper(dp, jumps, 0);
    }

    private int helper(int[] dp, int[] jumps, int currentIndex) {
        if (currentIndex == jumps.length - 1)
            return 0;
        if (jumps[currentIndex] == 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[currentIndex] != 0)
            return dp[currentIndex];

        int totalJumps = Integer.MAX_VALUE;
        int start = currentIndex + 1;
        int end = currentIndex + jumps[currentIndex];

        while (start < jumps.length && start <= end) {
            int minJumps = helper(dp, jumps, start++);
            if (minJumps != Integer.MAX_VALUE) {
                totalJumps = Math.min(totalJumps, minJumps + 1);
            }
        }
        dp[currentIndex] = totalJumps;
        return dp[currentIndex];
    }
}

class MinimumJumpstoreachtheendBottomupDynamicProgramming {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int start = 0; start < nums.length - 1; start++) {
            for (int end = start + 1; end <= start + nums[start] && end < nums.length; end++) {
                dp[end] = Math.min(dp[end], dp[start] + 1);
            }
        }

        return dp[nums.length - 1];
    }
}
