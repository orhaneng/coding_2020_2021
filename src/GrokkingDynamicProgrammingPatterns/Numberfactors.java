package GrokkingDynamicProgrammingPatterns;

public class Numberfactors {
    /*
    Problem Statement #
    Given a number ‘n’, implement a method to count how many possible ways there are to express ‘n’ as the sum of 1, 3, or 4.

    Example 1:

    n : 4
    Number of ways = 4
    Explanation: Following are the four ways we can exoress 'n' : {1,1,1,1}, {1,3}, {3,1}, {4}
    Example 2:

    n : 5
    Number of ways = 6
    Explanation: Following are the six ways we can express 'n' : {1,1,1,1,1}, {1,1,3}, {1,3,1}, {3,1,1},
    {1,4}, {4,1}
     */

    public static void main(String[] args) {
        //System.out.println(NumberfactorsBruteForce.countWays(4));
        //
        //System.out.println(NumberfactorsTopdownDynamicProgrammingwithMemoization.countWays(4));
        //System.out.println(NumberfactorsBottomupDynamicProgramming.countWays(4));
    }
}

class NumberfactorsBruteForce {

    /*
    The time complexity of the above algorithm is exponential O(3^n).
    The space complexity is O(n)O(n) which is used to store the recursion stack.

     */

    public static int countWays(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        int sum = countWays(n - 1) + countWays(n - 3) + countWays(n - 4);
        return sum;
    }
}

class NumberfactorsTopdownDynamicProgrammingwithMemoization {
    public static int countWays(int n) {
        int[] dp = new int[n + 1];
        return helper(n, dp);
    }

    public static int helper(int n, int[] dp) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        if (dp[n] == 0) {
            dp[n] = countWays(n - 1) + countWays(n - 3) + countWays(n - 4);
        }
        return dp[n];
    }
}

class NumberfactorsBottomupDynamicProgramming {

//The above solution has time and space complexity of O(n).

    public static int countWays(int n) {
        int[] dp = new int[n + 1];
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
        }

        return dp[n];
    }
}