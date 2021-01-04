package GrokkingDynamicProgrammingPatterns;

//https://leetcode.com/problems/longest-palindromic-subsequence/

/*
Problem Statement #
Given a sequence, find the length of its Longest Palindromic Subsequence (LPS). In a palindromic subsequence, elements read the same backward and forward.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

Example 1:

Input: "abdbca"
Output: 5
Explanation: LPS is "abdba".
Example 2:

Input: = "cddpd"
Output: 3
Explanation: LPS is "ddd".
Example 3:

Input: = "pqr"
Output: 1
Explanation: LPS could be "p", "q" or "r".
B
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(LongestPalindromicSubsequenceBottomupDynamicProgramming.longestPalindromeSubseq("cddpd"));
    }
}


class LongestPalindromicSubsequenceBruteForce {

    /*
    The time complexity of the above algorithm is exponential O(2^n)O(2
​n
​​ ), where ‘n’ is the length of the input sequence. The space complexity is O(n)O(n) which is used to store the recursion stack.

     */
    public static int longestPalindromeSubseq(String s) {
        return helper(s, 0, s.length() - 1);
    }

    public static int helper(String s, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return 0;
        }

        if (startIndex == endIndex) {
            return 1;
        }

        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            return 2 + helper(s, startIndex + 1, endIndex - 1);
        }

        int c1 = helper(s, startIndex + 1, endIndex);
        int c2 = helper(s, startIndex, endIndex - 1);

        return Math.max(c1, c2);

    }
}

class LongestPalindromicSubsequenceTopdownDynamicProgrammingwithMemoization {
    /*
    What is the time and space complexity of the above solution? Since our memoization array dp[st.length()][st.length()] stores
    the results for all the subproblems, we can conclude that we will not have more than N*NN∗N subproblems (where ‘N’ is
    the length of the input sequence). This means that our time complexity will be O(N^2).

    The above algorithm will be using O(N^2) space for the memoization array. Other than that we will use O(N)O(N) space for the recursion call-stack. So the total space complexity will be O(N^2 + N)O(N
    ​2+N), which is asymptotically equivalent to O(N^2)O(N
    ​2
    ​​ ).

     */
    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        return helper(dp, s, 0, s.length() - 1);
    }

    public static int helper(int[][] dp, String s, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return 0;
        }

        if (startIndex == endIndex) {
            return 1;
        }

        if (dp[startIndex][endIndex] == 0) {
            if (s.charAt(startIndex) == s.charAt(endIndex)) {
                dp[startIndex][endIndex] = 2 + helper(dp, s, startIndex + 1, endIndex - 1);
            } else {

                int c1 = helper(dp, s, startIndex + 1, endIndex);
                int c2 = helper(dp, s, startIndex, endIndex - 1);
                dp[startIndex][endIndex] = Math.max(c1, c2);
            }
        }
        return dp[startIndex][endIndex];

    }
}

class LongestPalindromicSubsequenceBottomupDynamicProgramming {

    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int startIndex = s.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < s.length(); endIndex++) {
                if (s.charAt(startIndex) == s.charAt(endIndex)) {
                    dp[startIndex][endIndex] = 2 + dp[startIndex + 1][endIndex - 1];
                } else {
                    dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]);
                }
                printMatrix(dp);
                System.out.println();
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4d", matrix[row][col]);
            }
            System.out.println();
        }
    }
}