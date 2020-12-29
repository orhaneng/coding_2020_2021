package GrokkingCodingPatterns.KnapsackDynamicProgramming;

public class _01Knapsack {

    public static void main(String[] args) {

/*        int[] profits = new int[100000];
        for (int i = 0; i < profits.length; i++) {
            profits[i] = i;
        }

        int[] weights = new int[100000];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = i;
        }*/
        int[] profits = {4, 5, 3, 7};
        int[] weights = {2, 3, 1, 4};
        int capacity = 5;

        //System.out.println(KnapsacksBruteForce.solveKnapsack(profits, weights, capacity));
        //System.out.println(KnapsacksMemoization.solveKnapsack(profits, weights, capacity));
        //System.out.println(KnapsacksBottomUpDynamicProgramming.solveKnapsack(profits, weights, capacity));
        //System.out.println(KnapsacksUpDynamicProgrammingConstantTime.solveKnapsack(profits, weights, capacity));
        System.out.println(Knapsacks.solveKnapsack(profits, weights, capacity));
        //System.out.println(solveKnapsack(profits, weights, capacity));
    }


}

class KnapsacksBruteForce {

    /*
    Time and Space complexity #
        The time complexity of the above algorithm is exponential O(2^n)O(2
        ​n
        ​​ ), where ‘n’ represents the total number of items. This can also be confirmed from the above recursion tree.
        As we can see, we will have a total of ‘31’ recursive calls – calculated through (2^n) + (2^n) - 1(2
        ​n
        ​​ )+(2
        ​n
        ​​ )−1, which is asymptotically equivalent to O(2^n)O(2
        ​n
        ​​ ).

        The space complexity is O(n)O(n). This space will be used to store the recursion stack.
        Since the recursive algorithm works in a depth-first fashion, which means that we can’t have more than ‘n’
        recursive calls on the call stack at any time.
     */
    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return knapsackRecursive(profits, weights, capacity, 0);
    }

    public static int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {

        //System.out.println("capacity:" + capacity + "currentIndex:" + currentIndex);

        if (capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }

        int profit1 = 0;

        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] +
                    knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
        }

        int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }
}


class KnapsacksMemoization {

    /*
    Time and Space complexity #
Since our memoization array dp[profits.length][capacity+1] stores the results for all subproblems,
we can conclude that we will not have more than N*CN∗C subproblems (where ‘N’ is the number of items
and ‘C’ is the knapsack capacity). This means that our time complexity will be O(N*C)O(N∗C).

The above algorithm will use O(N*C)O(N∗C) space for the memoization array. Other than that we will
use O(N)O(N) space for the recursion call-stack. So the total space complexity will be O(N*C + N)O(N∗C+N),
which is asymptotically equivalent to O(N*C).O(N∗C).
     */

    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return knapsackRecursive(dp, profits, weights, capacity, 0);
    }

    public static int knapsackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {

        if (capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }

        if (dp[currentIndex][capacity] != null) {
            return dp[currentIndex][capacity];
        }
        int profit1 = 0;

        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] +
                    knapsackRecursive(dp, profits, weights, capacity - weights[currentIndex], currentIndex + 1);
        }

        int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);
        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }
}



class KnapsacksBottomUpDynamicProgramming {

    /*
    Time and Space complexity #
The above solution has the time and space complexity of O(N*C)O(N∗C), where ‘N’
represents total items and ‘C’ is the maximum capacity.
     */
    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length) {
            return 0;
        }

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int c = 0; c < capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;

                if (weights[i] <= c)
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                profit2 = dp[i - 1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        }
        //printSelectedElements(dp, weights, profits, capacity);
        return dp[n - 1][capacity];
    }

    private static void printSelectedElements(int dp[][], int[] weights, int[] profits, int capacity) {
        System.out.print("Selected weights:");
        int totalProfit = dp[weights.length - 1][capacity];
        for (int i = weights.length - 1; i > 0; i--) {
            if (totalProfit != dp[i - 1][capacity]) {
                System.out.print(" " + weights[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }

        if (totalProfit != 0)
            System.out.print(" " + weights[0]);
        System.out.println("");
    }

}

class KnapsacksUpDynamicProgrammingCapacityTime {
    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length) {
            return 0;
        }

        int n = profits.length;
        int[][] dp = new int[2][capacity + 1];

        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = dp[1][c] = profits[0];
            }
        }


        for (int i = 1; i < n; i++) {
            for (int c = 0; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;

                if (weights[i] <= c)
                    profit1 = profits[i] + dp[(i - 1) % 2][c - weights[i]];
                profit2 = dp[(i - 1) % 2][c];
                dp[i % 2][c] = Math.max(profit1, profit2);
            }
        }
        //printSelectedElements(dp, weights, profits, capacity);
        return dp[(n - 1) % 2][capacity];
    }

    private static void printSelectedElements(int dp[][], int[] weights, int[] profits, int capacity) {
        System.out.print("Selected weights:");
        int totalProfit = dp[weights.length - 1][capacity];
        for (int i = weights.length - 1; i > 0; i--) {
            if (totalProfit != dp[i - 1][capacity]) {
                System.out.print(" " + weights[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }

        if (totalProfit != 0)
            System.out.print(" " + weights[0]);
        System.out.println("");
    }

}


class Knapsacks {
    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int c = 0; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;
                if (weights[i] <= c)
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                profit2 = dp[i - 1][c];

                dp[i][c] = Math.max(profit1, profit2);
            }
        }
        return dp[n - 1][capacity];
    }
}