package GrokkingDynamicProgrammingPatterns;

public class UnboundedKnapsack {

    public static void main(String[] args) {
        int[] weights = {1, 2, 3};
        int[] profits = {15, 20, 50};
        int capacity = 5;

        //System.out.println(UnboundedKnapsackBruteForce.solveKnapsack(profits, weights, capacity));
        //System.out.println(UnboundedKnapsackTopdownDynamicProgrammingwithMemoization.solveKnapsack(profits, weights, capacity));
        System.out.println(UnboundedKnapsackBottomupDynamicProgramming.solveKnapsack(profits, weights, capacity));
    }

}


class UnboundedKnapsackBruteForce {

    public static int solveKnapsack(int[] profits, int[] weigths, int capacity) {
        return knapsackRecursive(profits, weigths, capacity, 0);
    }

    public static int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length ||
                currentIndex >= profits.length)
            return 0;

        int profit1 = 0, profit2 = 0;

        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex);
        }

        profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);
        return Math.max(profit1, profit2);
    }
}

class UnboundedKnapsackTopdownDynamicProgrammingwithMemoization {

    public static int solveKnapsack(int[] profits, int[] weigths, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return knapsackRecursive(dp, profits, weigths, capacity, 0);
    }

    public static int knapsackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length ||
                currentIndex >= profits.length)
            return 0;

        if (dp[currentIndex][capacity] == null) {
            int profit1 = 0, profit2 = 0;

            if (weights[currentIndex] <= capacity) {
                profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights, capacity - weights[currentIndex], currentIndex);
            }

            profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);
            dp[currentIndex][capacity] = Math.max(profit1, profit2);
        }
        return dp[currentIndex][capacity];
    }
}

class UnboundedKnapsackBottomupDynamicProgramming {

    /*
    The above solution has time and space complexity of O(N*C)O(N∗C),
    where ‘N’ represents total items and ‘C’ is the maximum capacity.
     */
    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;

        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i][c - weights[i]];
                }
                if (i > 0)
                    profit2 = dp[i - 1][c];
                dp[i][c] = profit1 > profit2 ? profit1 : profit2;
            }
        }
        return dp[n - 1][capacity];

    }



}