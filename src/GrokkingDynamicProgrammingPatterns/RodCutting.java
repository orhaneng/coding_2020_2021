package GrokkingDynamicProgrammingPatterns;

public class RodCutting {
    /*
    Problem Statement #
        Given a rod of length ‘n’, we are asked to cut the rod and sell the pieces in a way that will maximize the profit.
        We are also given the price of every piece of length ‘i’ where ‘1 <= i <= n’.

        Example:

        Lengths: [1, 2, 3, 4, 5]
        Prices: [2, 6, 7, 10, 13]
        Rod Length: 5

        Let’s try different combinations of cutting the rod:

        Five pieces of length 1 => 10 price
        Two pieces of length 2 and one piece of length 1 => 14 price
        One piece of length 3 and two pieces of length 1 => 11 price
        One piece of length 3 and one piece of length 2 => 13 price
        One piece of length 4 and one piece of length 1 => 12 price
        One piece of length 5 => 13 price
     */

    public static void main(String[] args) {
//        int[] lengths = {1, 2, 3, 4, 5};
//        int[] prices = {2, 6, 7, 10, 13};
//        int rodLength = 5;
//
//        System.out.println(RodCuttingBottomupDynamicProgramming.solveRodCutting(lengths, prices, rodLength));
    }
}

class RodCuttingBottomupDynamicProgramming {

    /*
    The above solution has time and space complexity of O(N*C)O(N∗C), where ‘N’ represents total items and ‘C’ is the maximum capacity.
     */
    public static int solveRodCutting(int[] lengths, int[] prices, int n) {

        if (lengths.length == 0 || prices.length != lengths.length || n == 0)
            return 0;

        int[][] dp = new int[lengths.length][n + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int l = 1; l <= n; l++) {
                int price1 = 0, price2 = 0;
                if (lengths[i] <= l) {
                    price1 = prices[i] + dp[i][l - lengths[i]];
                }
                if (i > 0)
                    price2 = dp[i - 1][l];

                dp[i][l] = Math.max(price1, price2);
            }
        }
        return dp[lengths.length - 1][n];

    }
}
