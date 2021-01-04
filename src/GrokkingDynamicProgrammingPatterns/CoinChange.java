package GrokkingDynamicProgrammingPatterns;

public class CoinChange {
    /*
    Introduction #
Given an infinite supply of ‘n’ coin denominations and a total money amount,
we are asked to find the total number of distinct ways to make up that amount.

Example:

Denominations: {1,2,3}
Total amount: 5
Output: 5
Explanation: There are five ways to make the change for '5', here are those ways:
  1. {1,1,1,1,1}
  2. {1,1,1,2}
  3. {1,2,2}
  4. {1,1,3}
  5. {2,3}

     */

    public static void main(String[] args) {
        int[] denominations = {1, 2, 3};
        int total = 5;

        //System.out.println(CoinChangeBruteForce.countChange(denominations, total));
        //System.out.println(CoinChangeTopdownDynamicProgrammingwithMemoization.countChange(denominations, total));
        System.out.println(CoinChangeBottomupDynamicProgramming.countChange(denominations, total));
    }
}

class CoinChangeBruteForce {

    /*
    The time complexity of the above algorithm is exponential O(2^{C+T})O(2
​C+T
​​ ), where ‘C’ represents total coin denominations and ‘T’ is the total amount that we want to make change.
The space complexity will be O(C+T)O(C+T).



     */
    public static int countChange(int[] denominations, int total) {
        return helper(denominations, total, 0);
    }

    public static int helper(int[] denominations, int total, int currentIndex) {
        if (total == 0)
            return 1;

        if (denominations.length == 0 || currentIndex >= denominations.length) {
            return 0;
        }

        int sum1 = 0;
        if (denominations[currentIndex] <= total)
            sum1 = helper(denominations, total - denominations[currentIndex], currentIndex);
        int sum2 = helper(denominations, total, currentIndex + 1);

        return sum1 + sum2;
    }
}

class CoinChangeTopdownDynamicProgrammingwithMemoization {

    /*


     */
    public static int countChange(int[] denominations, int total) {
        Integer[][] dp = new Integer[denominations.length][total + 1];
        return helper(dp, denominations, total, 0);
    }

    public static int helper(Integer[][] dp, int[] denominations, int total, int currentIndex) {
        if (total == 0)
            return 1;

        if (denominations.length == 0 || currentIndex >= denominations.length) {
            return 0;
        }

        if (dp[currentIndex][total] == null) {
            int sum1 = 0;
            if (denominations[currentIndex] <= total)
                sum1 = helper(dp, denominations, total - denominations[currentIndex], currentIndex);
            int sum2 = helper(dp, denominations, total, currentIndex + 1);
            dp[currentIndex][total] = sum1 + sum2;
        }
        return dp[currentIndex][total];
    }
}

class CoinChangeBottomupDynamicProgramming {

    /*
        The above solution has time and space complexity of O(C*T)O(C∗T),
        where ‘C’ represents total coin denominations and ‘T’ is the total amount that we want to make change.
     */
    public static int countChange(int[] denominations, int total) {
        if (denominations.length == 0 || total == 0)
            return 0;

        int n = denominations.length;
        int[][] dp = new int[denominations.length][total + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= total; j++) {
                if (i > 0)
                    dp[i][j] = dp[i - 1][j];
                if (denominations[i] <= j) {
                    dp[i][j] += dp[i][j - denominations[i]];
                }
            }
        }

        return dp[n - 1][total];

    }


}