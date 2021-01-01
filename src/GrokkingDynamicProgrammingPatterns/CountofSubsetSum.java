package GrokkingDynamicProgrammingPatterns;

public class CountofSubsetSum {
    /*
    Problem Statement #
Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number ‘S’.

Example 1: #
Input: {1, 1, 2, 3}, S=4
Output: 3
The given set has '3' subsets whose sum is '4': {1, 1, 2}, {1, 3}, {1, 3}
Note that we have two similar sets {1, 3}, because we have two '1' in our input.
Example 2: #
Input: {1, 2, 7, 1, 5}, S=9
Output: 3
The given set has '3' subsets whose sum is '9': {2, 7}, {1, 7, 1}, {1, 2, 1, 5}

     */

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3};
        int s = 4;

        //System.out.println(CountofSubsetSumBruteForce.countSubsets(nums, s));
        //System.out.println(CountofSubsetSumTopdownDynamicProgrammingwithMemoization.countSubsets(nums, s));
        System.out.println(CountofSubsetSumBottomupDynamicProgramming.countSubsets(nums, s));
    }
}

class CountofSubsetSumBruteForce {

    /*
    The time complexity of the above algorithm is exponential O(2^n)O(2
​n
​​ ), where ‘n’ represents the total number. The space complexity is O(n)O(n), this memory is used to store the recursion stack.
     */
    public static int countSubsets(int[] nums, int sum) {
        return countSubsetsRecursive(nums, sum, 0);
    }

    private static int countSubsetsRecursive(int[] nums, int sum, int currentIndex) {
        if (sum == 0)
            return 1;

        if (nums.length == 0 || currentIndex >= nums.length)
            return 0;

        int sum1 = 0;
        if (nums[currentIndex] <= sum)
            sum1 = countSubsetsRecursive(nums, sum - nums[currentIndex], currentIndex + 1);

        int sum2 = countSubsetsRecursive(nums, sum, currentIndex + 1);

        return sum1 + sum2;
    }
}

class CountofSubsetSumTopdownDynamicProgrammingwithMemoization {


    public static int countSubsets(int[] nums, int sum) {

        Integer[][] dp = new Integer[nums.length][sum + 1];
        return countSubsetsRecursive(dp, nums, sum, 0);
    }

    private static int countSubsetsRecursive(Integer[][] dp, int[] nums, int sum, int currentIndex) {
        if (sum == 0)
            return 1;

        if (nums.length == 0 || currentIndex >= nums.length)
            return 0;

        if (dp[currentIndex][sum] == null) {
            int sum1 = 0;
            if (nums[currentIndex] <= sum)
                sum1 = countSubsetsRecursive(dp, nums, sum - nums[currentIndex], currentIndex + 1);

            int sum2 = countSubsetsRecursive(dp, nums, sum, currentIndex + 1);

            dp[currentIndex][sum] = sum1 + sum2;
        }
        return dp[currentIndex][sum];
    }
}

class CountofSubsetSumBottomupDynamicProgramming {

/*
The above solution has time and space complexity of O(N*S)O(N∗S), where ‘N’ represents total numbers and ‘S’ is the desired sum.
 */
    public static int countSubsets(int[] nums, int sum) {

        Integer[][] dp = new Integer[nums.length][sum + 1];

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (nums[0] == s ? 1 : 0);
        }

        for (int i = 1; i <n; i++) {
            for (int s = 1; s <=sum ; s++) {
                dp[i][s] = dp[i-1][s];
                if(s>=nums[i])
                    dp[i][s] +=dp[i-1][s-nums[i]];
            }
        }


        return dp[nums.length-1][sum];
    }

}