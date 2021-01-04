package GrokkingDynamicProgrammingPatterns;

public class Housethief {
    public static void main(String[] args) {
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        //System.out.println(HousethiefBruteForce.findMaxSteal(wealth));
        //System.out.println(HousethiefTopdownDynamicProgrammingwithMemoization.findMaxSteal(wealth));
        System.out.println(HousethiefBottomupDynamicProgramming.rob(wealth));
    }
}


class HousethiefBruteForce {

    public static int findMaxSteal(int[] wealth) {
        return helper(wealth, 0);
    }

    public static int helper(int[] wealth, int currentIndex) {
        if (currentIndex >= wealth.length) return 0;

        int current = wealth[currentIndex] + helper(wealth, currentIndex + 2);

        int next = helper(wealth, currentIndex + 1);

        return Math.max(current, next);
    }
}

class HousethiefTopdownDynamicProgrammingwithMemoization {

    public static int findMaxSteal(int[] wealth) {
        int[] dp = new int[wealth.length + 1];
        return helper(dp, wealth, 0);
    }

    public static int helper(int[] dp, int[] wealth, int currentIndex) {
        if (currentIndex >= wealth.length) return 0;

        if (dp[currentIndex] == 0) {
            int current = wealth[currentIndex] + helper(dp, wealth, currentIndex + 2);

            int next = helper(dp, wealth, currentIndex + 1);

            dp[currentIndex] = Math.max(current, next);
        }
        return dp[currentIndex];
    }
}

class HousethiefBottomupDynamicProgramming {

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int dp[] = new int[nums.length + 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(nums[i] + dp[i - 1], dp[i]);
        }
        return dp[nums.length];
    }


}