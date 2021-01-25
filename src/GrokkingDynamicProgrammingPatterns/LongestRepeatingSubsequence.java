package GrokkingDynamicProgrammingPatterns;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {

    }
}
/*
Problem Statement #
Given a sequence, find the length of its longest repeating subsequence (LRS). A repeating subsequence will be the one that appears at least twice in the original sequence and is not overlapping (i.e. none of the corresponding characters in the repeating subsequences have the same index).

Example 1:

Input: “t o m o r r o w”
Output: 2
Explanation: The longest repeating subsequence is “or” {tomorrow}.

Example 2:

Input: “a a b d b c e c”
Output: 3
Explanation: The longest repeating subsequence is “a b c” {a a b d b c e c}.

Example 3:

Input: “f m f f”
Output: 2
Explanation: The longest repeating subsequence is “f f” {f m f f, f m f f}. Please note the second last character is shared in LRS.
 */

class LongestRepeatingSubsequenceBruteForce {

    /*
    The time complexity of the above algorithm is exponential O(2^n)O(2
​n
​​ ), where ‘n’ is the length of the input sequence. The space complexity is O(n)O(n) which is used to store the recursion stack.
     */
    public int findLRSLength(String str) {
        return helper(str, 0, 0);
    }

    public int helper(String str, int i1, int i2) {
        if (i1 == str.length() || i2 == str.length()) {
            return 0;
        }
        if (i1 != i2 && str.charAt(i1) == str.charAt(i2)) {
            return 1 + helper(str, i1 + 1, i2 + 1);
        }

        int c1 = helper(str, i1, i2 + 1);
        int c2 = helper(str, i1 + 1, i2);

        return Math.max(c1, c2);
    }
}


class LongestRepeatingSubsequenceTopdownDynamicProgrammingwithMemoization {
    public int findLRSLength(String str) {
        Integer[][] dp = new Integer[str.length()][str.length()];
        return helper(dp, str, 0, 0);
    }

    public int helper(Integer[][] dp, String str, int i1, int i2) {
        if (i1 == str.length() || i2 == str.length()) {
            return 0;
        }

        if (dp[i1][i2] == null) {
            if (i1 != i2 && str.charAt(i1) == str.charAt(i2)) {
                return 1 + helper(dp, str, i1 + 1, i2 + 1);
            }

            int c1 = helper(dp, str, i1, i2 + 1);
            int c2 = helper(dp, str, i1 + 1, i2);

            dp[i1][i2] = Math.max(c1, c2);
        }
        return dp[i1][i2];
    }
}

class LongestRepeatingSubsequenceBottomupDynamicProgramming {

    /*
    The time and space complexity of the above algorithm is O(n^2)O(n
​2
​​ ), where ‘n’ is the length of the input sequence.
     */
    public int findLRSLength(String str) {
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        int maxlength = 0;

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= str.length(); j++) {
                if (i != j && str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                maxlength = Math.max(maxlength, dp[i][j]);
            }
        }
        return maxlength;
    }


}
