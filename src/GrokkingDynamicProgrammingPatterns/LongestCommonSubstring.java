package GrokkingDynamicProgrammingPatterns;

public class LongestCommonSubstring {
    /*
    Problem Statement #
    Given two strings ‘s1’ and ‘s2’, find the length of the longest substring which is common in both the strings.

    Example 1:

    Input: s1 = "abdca"
           s2 = "cbda"
    Output: 2
    Explanation: The longest common substring is "bd".
    Example 2:

    Input: s1 = "passport"
           s2 = "ppsspt"
    Output: 3
    Explanation: The longest common substring is "ssp".

     */

    public static void main(String[] args) {

        String s1 = "abdca";
        String s2 = "cbda";

        System.out.println(LongestCommonSubstringBruteForce.findLCSLength(s1, s2));
    }
}

class LongestCommonSubstringBruteForce {

    /*
        Because of the three recursive calls, the time complexity of the above algorithm is exponential O(3^{m+n})O(3
    ​m+n
    ​​ ), where ‘m’ and ‘n’ are the lengths of the two input strings. The space complexity is O(m+n)O(m+n),
    this space will be used to store the recursion stack.



     */
    public static int findLCSLength(String s1, String s2) {
        return helper(s1, s2, 0, 0, 0);
    }

    public static int helper(String s1, String s2, int index1, int index2, int count) {
        if (index1 >= s1.length() || index2 >= s2.length()) {
            return count;
        }

        if (s1.charAt(index1) == s2.charAt(index2)) {
            count = helper(s1, s2, index1 + 1, index2 + 1, count + 1);
        }

        int c1 = helper(s1, s2, index1 + 1, index2, 0);
        int c2 = helper(s1, s2, index1, index2 + 1, 0);

        return Math.max(count, Math.max(c1, c2));

    }
}

class LongestCommonSubstringTopdownDynamicProgrammingwithMemoization {

    /*
     */
    public static int findLCSLength(String s1, String s2) {

        int maxLength = Math.min(s1.length(), s2.length());

        Integer[][][] dp = new Integer[s1.length()][s2.length()][maxLength];

        return helper(dp, s1, s2, 0, 0, 0);
    }

    public static int helper(Integer[][][] dp, String s1, String s2, int index1, int index2, int count) {
        if (index1 >= s1.length() || index2 >= s2.length()) {
            return count;
        }

        if (dp[index1][index2][count] == null) {
            int c1 = count;
            if (s1.charAt(index1) == s2.charAt(index2)) {
                c1 = helper(dp, s1, s2, index1 + 1, index2 + 1, count + 1);
            }

            int c2 = helper(dp, s1, s2, index1 + 1, index2, 0);
            int c3 = helper(dp, s1, s2, index1, index2 + 1, 0);

            dp[index1][index2][count] = Math.max(c3, Math.max(c1, c2));
        }
        return dp[index1][index2][count];
    }
}

class LongestCommonSubstringBottomupDynamicProgramming {

    /*
    The time and space complexity of the above algorithm is O(m*n)O(m∗n), where ‘m’ and ‘n’ are the lengths of the two input strings.
     */
    public static int findLCSLength(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }

}