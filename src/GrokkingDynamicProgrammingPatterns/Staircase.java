package GrokkingDynamicProgrammingPatterns;

//

/*
Problem Statement #
Given a stair with ‘n’ steps, implement a method to count how many possible ways are there to reach the top of the staircase,
given that, at every step you can either take 1 step, 2 steps, or 3 steps.

Example 1:

Number of stairs (n) : 3
Number of ways = 4
Explanation: Following are the four ways we can climb : {1,1,1}, {1,2}, {2,1}, {3}
Example 2:

Number of stairs (n) : 4
Number of ways = 7
Explanation: Following are the seven ways we can climb : {1,1,1,1}, {1,1,2}, {1,2,1}, {2,1,1},
{2,2}, {1,3}, {3,1}
 */
public class Staircase {
    public static void main(String[] args) {
        //System.out.println(StaircaseBruteForce.countWays(4));
        //System.out.println(StaircaseTopdownDynamicProgrammingwithMemoization.countWays(4));
        System.out.println(StaircaseBottomupDynamicProgramming.countWays(3));
        //System.out.println(StaircaseMemoryoptimization.countWays(3));
    }
}

class StaircaseBruteForce {

    /*
    The time complexity of the above algorithm is exponential O(3^n) as we are making three recursive call in the same function.
    The space complexity is O(n)O(n)
which is used to store the recursion stack.
     */
    public static int countWays(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }
}

class StaircaseTopdownDynamicProgrammingwithMemoization {

    /*
        What is the time and space complexity of the above solution?
        Since our memoization array dp[n+1] stores the results for all the subproblems,
        we can conclude that we will not have more than n+1n+1 subproblems (where ‘n’ represents the total number of steps).
        This means that our time complexity will be O(N)O(N). The space complexity will also be O(n)O(n); this space will be
        used to store the recursion-stack.
     */
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
            return 2;

        if (dp[n] == 0) {
            dp[n] = countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }

        return dp[n];

    }
}

class StaircaseBottomupDynamicProgramming {
    //The above solution has time and space complexity of O(n)O(n).

    public static int countWays(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }
}

class StaircaseMemoryoptimization {
    //The above solution has time and space complexity of O(n)O(n).

    public static int countWays(int n) {
        if (n < 2) return 1;
        if (n == 2) return 2;
        int n1 = 1, n2 = 1, n3 = 2, temp;
        for (int i = 3; i <= n; i++) {
            temp = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = temp;
        }
        return n3;
    }
}