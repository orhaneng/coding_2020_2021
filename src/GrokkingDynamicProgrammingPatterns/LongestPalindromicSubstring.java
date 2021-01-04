package GrokkingDynamicProgrammingPatterns;

public class LongestPalindromicSubstring {
    /*
    Problem Statement #
    Given a string, find the length of its Longest Palindromic Substring (LPS). In a palindromic string,
    elements read the same backward and forward.

    Example 1:

    Input: "abdbca"
    Output: 3
    Explanation: LPS is "bdb".
    Example 2:

    Input: = "cddpd"
    Output: 3
    Explanation: LPS is "dpd".
    Example 3:

    Input: = "pqr"
    Output: 1
    Explanation: LPS could be "p", "q" or "r".
     */
    public static void main(String[] args) {

        System.out.println(LongestPalindromicSubstringBottomupDynamicProgramming.longestPalindrome("abdbca"));
    }

}

class LongestPalindromicSubstringBruteForce {

    /*
    Due to the three recursive calls, the time complexity of the above algorithm is exponential O(3^n)O(3
​n
​​ ), where ‘n’ is the length of the input string. The space complexity is O(n)O(n) which is used to store the recursion stack.

     */
    public int longestPalindrome(String s) {
        return helper(s, 0, s.length() - 1);
    }

    public int helper(String s, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;

        if (startIndex == endIndex)
            return 1;

        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            int remainingLength = endIndex - startIndex - 1;
            if (remainingLength == helper(s, startIndex + 1, endIndex - 1)) {
                return remainingLength + 2;
            }
        }

        int c1 = helper(s, startIndex + 1, endIndex);
        int c2 = helper(s, startIndex, endIndex - 1);
        return Math.max(c1, c2);
    }
}

class LongestPalindromicSubstringTopdownDynamicProgrammingwithMemoization {

    /*
    The above algorithm has a time and space complexity of O(n^2)O(n
​2
​​ ) because we will not have more than n*nn∗n subproblems.

     */
    public int longestPalindrome(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];

        return helper(dp, s, 0, s.length() - 1);
    }

    public int helper(Integer[][] dp, String s, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;

        if (dp[startIndex][endIndex] == null) {
            if (startIndex == endIndex)
                return 1;

            if (s.charAt(startIndex) == s.charAt(endIndex)) {
                int remainingLength = endIndex - startIndex - 1;
                if (remainingLength == helper(dp, s, startIndex + 1, endIndex - 1)) {
                    return remainingLength + 2;
                }
            }

            int c1 = helper(dp, s, startIndex + 1, endIndex);
            int c2 = helper(dp, s, startIndex, endIndex - 1);
            dp[startIndex][endIndex] = Math.max(c1, c2);
        }
        return dp[startIndex][endIndex];
    }
}

class LongestPalindromicSubstringBottomupDynamicProgramming {

    /*
    The above algorithm has a time and space complexity of O(n^2)O(n
​2
​​ ) because we will not have more than n*nn∗n subproblems.

     */
    public static int longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        int maxLength = 1;
        int start= 0;
        int end=0;
        for (int startIndex = s.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex+1; endIndex < s.length(); endIndex++) {
                if (s.charAt(startIndex) == s.charAt(endIndex)) {
                    if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
                        dp[startIndex][endIndex] = true;
                        if(maxLength<endIndex - startIndex + 1){
                            maxLength = endIndex - startIndex + 1;
                            //end= endIndex;
                           // start=startIndex;
                        }
                    }
                }
            }
        }
        return maxLength;
    }
}