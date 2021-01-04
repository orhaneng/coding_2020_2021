package GrokkingDynamicProgrammingPatterns;


/*
We are given a ribbon of length ‘n’ and a set of possible ribbon lengths.
Now we need to cut the ribbon into the maximum number of pieces that comply with the above-mentioned possible lengths.
Write a method that will return the count of pieces.

Example 1:

n: 5
Ribbon Lengths: {2,3,5}
Output: 2
Explanation: Ribbon pieces will be {2,3}.
Example 2:

n: 7
Ribbon Lengths: {2,3}
Output: 3
Explanation: Ribbon pieces will be {2,2,3}.
Example 3:

n: 13
Ribbon Lengths: {3,5,7}
Output: 3
Explanation: Ribbon pieces will be {3,3,7}.

 */
public class MaximumRibbonCut {
    public static void main(String[] args) {

        int[] ribbons = {2, 3, 5};
        int total = 5;
        //System.out.println(MaximumRibbonCutBruteForce.countRibbonPieces(ribbons, 5));
        System.out.println(MaximumRibbonCutBottomupDynamicProgramming.countRibbonPieces(ribbons, 5));
    }
}

class MaximumRibbonCutBruteForce {

    /*
    The time complexity of the above algorithm is exponential O(2^{L+T})O(2
​L+T
​​ ), where ‘L’ represents total ribbon lengths and ‘N’ is the total length that we want to cut. The space complexity will b

     */
    public static int countRibbonPieces(int[] ribbonLengths, int total) {
        int maxPieces = helper(ribbonLengths, total, 0);
        return maxPieces == Integer.MIN_VALUE ? -1 : maxPieces;
    }

    public static int helper(int[] ribbonLengths, int total, int currentIndex) {
        if (total == 0)
            return 0;
        if (ribbonLengths.length == 0 || currentIndex >= ribbonLengths.length) {
            return Integer.MIN_VALUE;
        }

        int c1 = Integer.MIN_VALUE;
        if (ribbonLengths[currentIndex] <= total) {
            int result = helper(ribbonLengths, total - ribbonLengths[currentIndex], currentIndex);
            if (result != Integer.MIN_VALUE) {
                c1 = result + 1;
            }
        }

        int c2 = helper(ribbonLengths, total, currentIndex + 1);
        return Math.max(c1, c2);
    }
}

class MaximumRibbonCutBottomupDynamicProgramming {

    public static int countRibbonPieces(int[] ribbonLengths, int total) {
        int n = ribbonLengths.length;
        int[][] dp = new int[n][total + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= total; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int t = 1; t <= total; t++) {
                if (i > 0)
                    dp[i][t] = dp[i - 1][t];
                if (t >= ribbonLengths[i] && dp[i][t - ribbonLengths[i]] != Integer.MAX_VALUE) {
                    dp[i][t] = Math.max(dp[i][t], dp[i][t - ribbonLengths[i]] + 1);
                }
            }
        }
        return dp[n - 1][total] == Integer.MIN_VALUE ? -1 : dp[n - 1][total];
    }


}