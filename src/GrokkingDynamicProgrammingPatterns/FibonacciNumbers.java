package GrokkingDynamicProgrammingPatterns;

public class FibonacciNumbers {
    public static void main(String[] args) {
        //System.out.println(FibonacciNumbersBruteForce.CalculateFibonacciNumbers(5));
        //System.out.println(FibonacciNumbersTopdownwithMemoization.CalculateFibonacciNumbers(5));
        System.out.println(FibonacciNumbersBottomupwithTabulation.CalculateFibonacciNumbers(5));
    }
}

class FibonacciNumbersBruteForce {
    public static int CalculateFibonacciNumbers(int n) {
        if (n < 2) return n;

        return CalculateFibonacciNumbers(n - 1) + CalculateFibonacciNumbers(n - 2);
    }
}


//https://leetcode.com/problems/fibonacci-number/

class FibonacciNumbersTopdownwithMemoization {


    public static int CalculateFibonacciNumbers(int n) {

        int[] dp = new int[n + 1];

        return helper(dp, n);
    }

    public static int helper(int[] dp, int n) {
        if (n < 2) return n;

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = helper(dp, n - 1) + helper(dp, n - 2);
        return dp[n];
    }
}

class FibonacciNumbersBottomupwithTabulation {

    public static int CalculateFibonacciNumbers(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

}