package GrokkingDynamicProgrammingPatterns;

/*
Problem Statement #
Given a string and a pattern, write a method to count the number of times the pattern appears in the string as a subsequence.

Example 1: Input: string: “baxmx”, pattern: “ax”
Output: 2
Explanation: {baxmx, baxmx}.

Example 2:

Input: string: “tomorrow”, pattern: “tor”
Output: 4
Explanation: Following are the four occurences: {tomorrow, tomorrow, tomorrow, tomorrow}.


 */
public class SubsequencePatternMatching {
    public static void main(String[] args) {

    }
}


class SubsequencePatternMatchingBruteForce {

    /*
    The time complexity of the above algorithm is exponential O(2^{m})O(2
​m
​​ ), where ‘m’ is the length of the string, as our recursion stack will not be deeper than m. The space complexity is O(m)O(m) which is used to store the recursion stack.
     */
    public int findSPMCount(String str, String pat) {
        return helper(str, pat, 0, 0);
    }

    public int helper(String str, String pat, int indexStr, int indexPat) {
        if (indexPat == pat.length())
            return 0;

        if (indexStr == str.length())
            return 0;

        int c1 = 0;
        if (str.charAt(indexStr) == pat.charAt(indexPat))
            c1 = helper(str, pat, indexStr + 1, indexPat + 1);

        int c2 = helper(str, pat, indexStr + 1, indexPat);
        return c1 + c2;
    }
}

class SubsequencePatternMatchingTopdownDynamicProgrammingwithMemoization {
    public int findSPMCount(String str, String pat) {
        Integer[][] dp = new Integer[str.length()][pat.length()];
        return helper(dp, str, pat, 0, 0);
    }

    public int helper(Integer[][] dp, String str, String pat, int indexStr, int indexPat) {
        if (indexPat == pat.length())
            return 0;

        if (indexStr == str.length())
            return 0;

        if (dp[indexStr][indexPat] == null) {
            int c1 = 0;
            if (str.charAt(indexStr) == pat.charAt(indexPat))
                c1 = helper(dp, str, pat, indexStr + 1, indexPat + 1);

            int c2 = helper(dp, str, pat, indexStr + 1, indexPat);
            dp[indexStr][indexPat] = c1 + c2;
        }
        return dp[indexStr][indexPat];
    }
}

class SubsequencePatternMatchingBottomupDynamicProgramming {

    /*
    The time and space complexity of the above algorithm is O(m*n)O(m∗n), where ‘m’ and ‘n’ are the lengths of
    the string and the pattern respectively.
     */
    public int findSPMCount(String str, String pat) {
        if (pat.length() == 0)
            return 1;
        if (str.length() == 0 || pat.length() > str.length())
            return 0;

        int[][] dp = new int[str.length() + 1][pat.length() + 1];

        for (int i = 0; i <= str.length(); i++) {
            dp[i][0] = 1;
        }

        for (int strIndex = 1; strIndex <= str.length(); strIndex++) {
            for (int patIndex = 1; patIndex <= pat.length(); patIndex++) {
                if (str.charAt(strIndex - 1) == pat.charAt(patIndex - 1)) {
                    dp[strIndex][patIndex] = dp[strIndex - 1][patIndex - 1];
                }
                dp[strIndex][patIndex] += dp[strIndex - 1][patIndex];
            }
        }
        return dp[str.length()][pat.length()];
    }
}