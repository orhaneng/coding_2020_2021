package GrokkingDynamicProgrammingPatterns;

/*
Problem Statement #
Given two strings ‘s1’ and ‘s2’, find the length of the longest subsequence which is common in both the strings.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without
changing the order of the remaining elements.

Example 1:

Input: s1 = "abdca"
       s2 = "cbda"
Output: 3
Explanation: The longest common subsequence is "bda".
Example 2:

Input: s1 = "passport"
       s2 = "ppsspt"
Output: 5
Explanation: The longest common subsequence is "psspt".

 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {

        String s1 = "abdca";
        String s2 = "cbda";

        System.out.println(LongestCommonSubsequenceBruteForce.longestCommonSubsequence(s1, s2));
    }
}


class LongestCommonSubsequenceBruteForce {

    /*
    The time complexity of the above algorithm is exponential O(2^{m+n})O(2
​m+n
​​ ), where ‘m’ and ‘n’ are the lengths of the two input strings. The space complexity is O(n+m)O(n+m) which is used to store the recursion stack.
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];

        return helper(dp, text1, text2, 0, 0);
    }

    public static int helper(Integer[][] dp, String text1, String text2, int index1, int index2) {
        if (index1 >= text1.length() || index2 >= text2.length()) {
            return 0;
        }

        if (dp[index1][index2] == null) {
            if (text1.charAt(index1) == text2.charAt(index2)) {
                dp[index1][index2] = 1 + helper(dp, text1, text2, index1 + 1, index2 + 1);
            } else {
                int c1 = helper(dp, text1, text2, index1 + 1, index2);
                int c2 = helper(dp, text1, text2, index1, index2 + 1);

                dp[index1][index2] = Math.max(c1, c2);

            }

        }
        return dp[index1][index2];
    }


}

class LongestCommonSubsequenceTopdownDynamicProgrammingwithMemoization {
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int maxLength = 0;
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
                maxLength = Math.max(maxLength,dp[i][j]);
            }
        }
        return maxLength;
    }
}