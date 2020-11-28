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
        for(int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0) {
                min = Math.min(min, dp[i - j*j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
