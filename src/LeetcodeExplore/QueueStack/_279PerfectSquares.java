package LeetcodeExplore.QueueStack;
//https://leetcode.com/problems/perfect-squares/
//https://www.youtube.com/watch?v=K715avFmZIk&ab_channel=AkshayGoyal
import java.lang.reflect.Array;
import java.util.Arrays;

public class _279PerfectSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }

        }
        return dp[n];
    }
}
