package GrokkingDynamicProgrammingPatterns;

/*
Problem Statement #
Given two sequences ‘s1’ and ‘s2’, write a method to find the length of the shortest sequence which has ‘s1’ and ‘s2’ as subsequences.

Example 2:

Input: s1: "abcf" s2:"bdcf"
Output: 5
Explanation: The shortest common super-sequence (SCS) is "abdcf".
Example 2:

Input: s1: "dynamic" s2:"programming"
Output: 15
Explanation: The SCS is "dynprogrammicng".

 */
public class ShortestCommonSupersequence {

}


class ShortestCommonSupersequenceBruteForce {

    /*
    The time complexity of the above algorithm is exponential O(2^{n+m})O(2
​n+m
​​ ), where ‘n’ and ‘m’ are the lengths of the input sequences. The space complexity is O(n+m)O(n+m) which is used to store the recursion stack.
     */
    public static int findSCSLength(String s1, String s2) {
        return helper(s1, s2, 0, 0);
    }

    private static int helper(String s1, String s2, int id1, int id2) {
        if (id1 == s1.length())
            return s2.length() - id2;
        if (id2 == s2.length())
            return s1.length() - id1;

        if (s1.charAt(id1) == s2.charAt(id2))
            return 1 + helper(s1, s2, id1 + 1, id2 + 1);

        int length1 = 1 + helper(s1, s2, id1, id2 + 1);
        int length2 = 1 + helper(s1, s2, id1 + 1, id2);

        return Math.min(length1, length2);
    }
}

class ShortestCommonSupersequenceTopdownDynamicProgrammingwithMemoization {

    /*
    The time complexity of the above algorithm is exponential O(2^{n+m})O(2
​n+m
​​ ), where ‘n’ and ‘m’ are the lengths of the input sequences. The space complexity is O(n+m)O(n+m) which is used to store the recursion stack.
     */
    public static int findSCSLength(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length()][s2.length()];
        return helper(dp, s1, s2, 0, 0);
    }

    private static int helper(Integer[][] dp, String s1, String s2, int id1, int id2) {
        if (id1 == s1.length())
            return s2.length() - id2;
        if (id2 == s2.length())
            return s1.length() - id1;

        if (dp[id1][id2] == null) {
            if (s1.charAt(id1) == s2.charAt(id2))
                return 1 + helper(dp, s1, s2, id1 + 1, id2 + 1);

            int length1 = 1 + helper(dp, s1, s2, id1, id2 + 1);
            int length2 = 1 + helper(dp, s1, s2, id1 + 1, id2);

            dp[id1][id2] = Math.min(length1, length2);
        }
        return dp[id1][id2];
    }

}

class ShortestCommonSupersequenceBottomupDynamicProgramming {

    //The time and space complexity of the above algorithm is O(n*m)O(n∗m).

    public static int findSCSLength(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= s1.length(); j++) {
            dp[j][0] = j;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
