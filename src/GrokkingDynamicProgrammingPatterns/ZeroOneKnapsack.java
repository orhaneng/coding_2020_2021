package GrokkingDynamicProgrammingPatterns;

public class ZeroOneKnapsack {

    public static void main(String[] args) {
        int[] profits = {4, 5, 3, 7};
        int[] weights = {2, 3, 1, 4};
        int capacity = 5;

        //System.out.println(ZeroOneKnapsackBruteForce.solveKnapsack(profits, weights, capacity));
        //System.out.println(ZeroOneKnapsackTopdownDynamicProgrammingwithMemoization.solveKnapsack(profits, weights, capacity));
        //System.out.println(ZeroOneKnapsackBottomupDynamicProgramming.solveKnapsack(profits, weights, capacity));
        System.out.println(ZeroOneKnapsackCapacitySpace.solveKnapsack(profits, weights, capacity));
    }
}


class ZeroOneKnapsackBruteForce {

    /*
    The time complexity of the above algorithm is exponential O(2^n)O(2
​n
​​ ), where ‘n’ represents the total number of items. This can also be confirmed from the above recursion tree. As we can see that we will have a total of ‘31’ recursive calls – calculated through (2^n) + (2^n) - 1(2
​n
​​ )+(2
​n
​​ )−1, which is asymptotically equivalent to O(2^n)O(2
​n
​​ ).

The space complexity is O(n)O(n). This space will be used to store the recursion stack. Since our recursive algorithm works in a depth-first fashion, which means, we can’t have more than ‘n’ recursive calls on the call stack at any time.


     */
    public static int solveKnapsack(int[] profits, int[] weigths, int capacity) {
        return knapsackRecursive(profits, weigths, capacity, 0);
    }

    public static int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        int profit1 = 0, profit2 = 0;

        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
        }

        profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);
        return Math.max(profit1, profit2);

    }
}

class ZeroOneKnapsackTopdownDynamicProgrammingwithMemoization {

    //time O(N*C)    // N- NUMBER OF ITEM , C CAPACITY
    //space(N*C)

    /*
    What is the time and space complexity of the above solution? Since our memoization array dp[profits.length][capacity+1] stores the results for all the subproblems, we can conclude that we will not have more than N*CN∗C subproblems (where ‘N’ is the number of items and ‘C’ is the knapsack capacity). This means that our time complexity will be O(N*C)O(N∗C).

The above algorithm will be using O(N*C)O(N∗C) space for the memoization array. Other than that we will use O(N)O(N) space for the recursion call-stack. So the total space complexity will be O(N*C + N)O(N∗C+N), which is asymptotically equivalent to O(N*C)O(N∗C).
     */

    public static int solveKnapsack(int[] profits, int[] weigths, int capacity) {

        Integer[][] dp = new Integer[profits.length][capacity + 1];

        return knapsackRecursive(dp, profits, weigths, capacity, 0);
    }

    public static int knapsackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        if (dp[currentIndex][capacity] != null) {
            return dp[currentIndex][capacity];
        }
        int profit1 = 0, profit2 = 0;

        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights, capacity - weights[currentIndex], currentIndex + 1);
        }

        profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);
        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];

    }
}

class ZeroOneKnapsackBottomupDynamicProgramming {

    /*
    The above solution has time and space complexity of O(N*C)O(N∗C), where ‘N’ represents total items and ‘C’ is the maximum capacity.
     */

    public static int solveKnapsack(int[] profits, int[] weigths, int capacity) {

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int c = 0; c <= capacity; c++) {
            if (weigths[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;

                if (weigths[i] <= c) {
                    profit1 = profits[i] + dp[i - 1][c - weigths[i]];
                }
                profit2 = dp[i - 1][c];

                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        printSelectedElements(dp, weigths, profits, capacity);
        return dp[n - 1][capacity];
    }

    public static void printSelectedElements(int[][] dp, int[] weights, int[] profits, int capacity) {
        int totalPoint = dp[profits.length - 1][capacity];

        for (int i = profits.length; i > 0; i--) {
            if (totalPoint != dp[i - 1][capacity]) {
                System.out.println(weights[i]);
                capacity -= weights[i];
                totalPoint -= profits[i];
            }
        }
    }
}

class ZeroOneKnapsackCapacitySpace {

    /*
    The above solution has time and space complexity of O(N*C)O(N∗C), where ‘N’ represents total items and ‘C’ is the maximum capacity.
     */

    public static int solveKnapsack(int[] profits, int[] weigths, int capacity) {

        if (capacity <= 0 || profits.length == 0 || weigths.length != profits.length) {
            return 0;
        }
        int n = profits.length;

        int[][] dp = new int[2][capacity + 1];

        for (int c = 0; c <= capacity; c++) {
            if (weigths[0] <= c) {
                dp[0][c] = dp[1][c] = profits[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0, profit2 = 0;

                if (weigths[i] <= c) {
                    profit1 = profits[i] + dp[(i - 1) % 2][c - weigths[i]];
                }
                profit2 = dp[(i - 1) % 2][c];

                dp[i % 2][c] = Math.max(profit1, profit2);
            }
        }

        //printSelectedElements(dp, weigths, profits, capacity);
        return dp[(n - 1) % 2][capacity];
    }

    public static void printSelectedElements(int[][] dp, int[] weights, int[] profits, int capacity) {
        int totalPoint = dp[profits.length - 1][capacity];

        for (int i = profits.length; i > 0; i--) {
            if (totalPoint != dp[i - 1][capacity]) {
                System.out.println(weights[i]);
                capacity -= weights[i];
                totalPoint -= profits[i];
            }
        }
    }
}

class PrintMatrix {
    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4d", matrix[row][col]);
            }
            System.out.println();
        }
    }
}