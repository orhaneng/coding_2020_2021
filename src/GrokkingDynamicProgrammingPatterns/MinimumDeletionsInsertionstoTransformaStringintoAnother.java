package GrokkingDynamicProgrammingPatterns;

//https://leetcode.com/problems/delete-operation-for-two-strings/

public class MinimumDeletionsInsertionstoTransformaStringintoAnother {

    /*
    Problem Statement #
Given strings s1 and s2, we need to transform s1 into s2 by deleting and inserting characters. Write a function to calculate the count of the minimum number of deletion and insertion operations.

Example 1:

Input: s1 = "abc"
       s2 = "fbc"
Output: 1 deletion and 1 insertion.
Explanation: We need to delete {'a'} and insert {'f'} to s1 to transform it into s2.
Example 2:

Input: s1 = "abdca"
       s2 = "cbda"
Output: 2 deletions and 1 insertion.
Explanation: We need to delete {'a', 'c'} and insert {'c'} to s1 to transform it into s2.
Example 3:

Input: s1 = "passport"
       s2 = "ppsspt"
Output: 3 deletions and 1 insertion
Explanation: We need to delete {'a', 'o', 'r'} and insert {'p'} to s1 to transform it into s2.

     */
    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "fbc";

        System.out.println(minDistance(s1, s2));
    }

    public static int minDistance(String word1, String word2) {
        return help(word1, word2, 0, 0);
    }

    public static int help(String word1, String word2, int id1, int id2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        int maxLength = 0;

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }
}

