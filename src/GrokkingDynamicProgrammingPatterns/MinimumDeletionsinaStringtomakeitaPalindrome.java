package GrokkingDynamicProgrammingPatterns;

public class MinimumDeletionsinaStringtomakeitaPalindrome {

    /*
    Problem Statement #
Given a string, find the minimum number of characters that we can remove to make it a palindrome.

Example 1:

Input: "abdbca"
Output: 1
Explanation: By removing "c", we get a palindrome "abdba".
Example 2:

Input: = "cddpd"
Output: 2
Explanation: Deleting "cp", we get a palindrome "ddd".
Example 3:

Input: = "pqr"
Output: 2
Explanation: We have to remove any two characters to get a palindrome, e.g. if we
remove "pq", we get palindrome "r".

The time and space complexity of the above algorithm is O(n^2)O(n
​2
​​ ), where ‘n’ is the length of the input string.
     */

    public static void main(String[] args) {

    }

    public int findMinimumDeletions(String st) {
        return st.length() - maxlengthofPalString(st);
    }

    public int maxlengthofPalString(String st) {
        int[][] dp = new int[st.length()][st.length()];
        for (int i = 0; i < st.length(); i++) {
            dp[i][i] = 1;
        }

        for (int start = st.length(); start >= 0; start--) {
            for (int end = start + 1; end < st.length(); end++) {
                if (st.charAt(start) == st.charAt(end)) {
                    dp[start][end] = 2 + dp[start + 1][end - 1];
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
            }
        }
        return dp[0][st.length() - 1];
    }
}
