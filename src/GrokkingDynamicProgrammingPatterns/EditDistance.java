package GrokkingDynamicProgrammingPatterns;

/*
Problem Statement #
Given strings s1 and s2, we need to transform s1 into s2 by deleting, inserting, or replacing characters. Write a function to calculate the count of the minimum number of edit operations.

Example 1:

Input: s1 = "bat"
       s2 = "but"
Output: 1
Explanation: We just need to replace 'a' with 'u' to transform s1 to s2.
Example 2:

Input: s1 = "abdca"
       s2 = "cbda"
Output: 2
Explanation: We can replace first 'a' with 'c' and delete second 'c'.
Example 3:

Input: s1 = "passpot"
       s2 = "ppsspqrt"
Output: 3
Explanation: Replace 'a' with 'p', 'o' with 'q', and insert 'r'.

 */
public class EditDistance {
    public static void main(String[] args) {
        String s1 = "bat";
        String s2 = "but";

        System.out.println(EditDistanceBruteForce.minDistance(s1, s2));
    }
}

class EditDistanceBruteForce {
    public static int minDistance(String word1, String word2) {
        return helper(word1, word2, 0, 0);
    }

    /*
    Because of the three recursive calls, the time complexity of the above algorithm is exponential O(3^{m+n})O(3
​m+n
​​ ), where ‘m’ and ‘n’ are the lengths of the two input strings.
The space complexity is O(n+m)O(n+m) which is used to store the recursion stack.
     */
    public static int helper(String word1, String word2, int idx1, int idx2) {
        if (idx1 == word1.length())
            return word2.length() - idx2;
        if (idx2 == word2.length())
            return word1.length() - idx1;

        if (word1.charAt(idx1) == word2.charAt(idx2))
            return helper(word1, word2, idx1 + 1, idx2 + 1);

        int c1 = 1 + helper(word1, word2, idx1 + 1, idx2);
        int c2 = 1 + helper(word1, word2, idx1, idx2 + 1);
        int c3 = 1 + helper(word1, word2, idx1 + 1, idx2 + 1);

        return Math.min(c1, Math.min(c2, c3));
    }
}


class EditDistanceTopDownDynamicProgrammingwithMemoization {

    /*
    What is the time and space complexity of the above solution?
    Since our memoization array dp[s1.length()][s2.length()] stores the results
    for all the subproblems, we can conclude that we will not have more than m*nm∗n subproblems (where ‘m’ and ‘n’ are the lengths of the two input strings.). This means that our time complexity will be O(m*n)O(m∗n).

    The above algorithm will be using O(m*n)O(m∗n) space for the memoization array.
    Other than that we will use O(m+n)O(m+n) space for the recursion call-stack.
    So the total space complexity will be O(m*n + (m+n))O(m∗n+(m+n)),
    which is asymptotically equivalent to O(m*n)O(m∗n).

     */
    public static int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length() + 1][word2.length() + 1];

        return helper(dp, word1, word2, 0, 0);
    }

    /*
    Because of the three recursive calls, the time complexity of the above algorithm is exponential O(3^{m+n})O(3
​m+n
​​ ), where ‘m’ and ‘n’ are the lengths of the two input strings.
The space complexity is O(n+m)O(n+m) which is used to store the recursion stack.
     */
    public static int helper(Integer[][] dp, String word1, String word2, int idx1, int idx2) {
        if (idx1 == word1.length())
            return word2.length() - idx2;
        if (idx2 == word2.length())
            return word1.length() - idx1;

        if (dp[idx1][idx2] == null) {
            if (word1.charAt(idx1) == word2.charAt(idx2))
                return helper(dp, word1, word2, idx1 + 1, idx2 + 1);

            int c1 = helper(dp, word1, word2, idx1 + 1, idx2);
            int c2 = helper(dp, word1, word2, idx1, idx2 + 1);
            int c3 = helper(dp, word1, word2, idx1 + 1, idx2 + 1);

            dp[idx1][idx2] = 1 + Math.min(c1, Math.min(c2, c3));
        }
        return dp[idx1][idx2];
    }
}


class EditDistanceBottomupDynamicProgramming {
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i1 = 0; i1 <= word1.length(); i1++) {
            dp[i1][0] = i1;
        }
        for (int i2 = 0; i2 <= word2.length(); i2++) {
            dp[0][i2] = i2;
        }

        for (int i1 = 1; i1 <= word1.length(); i1++) {
            for (int i2 = 1; i2 <= word2.length(); i2++) {
                if (word1.charAt(i1 - 1) == word2.charAt(i2 - 1)) {
                    dp[i1][i2] = dp[i1 - 1][i2 - 1];
                } else {
                    dp[i1][i2] = 1 + Math.min(dp[i1 - 1][i2], //delete
                            Math.min(dp[i1][i2 - 1], //insert
                                    dp[i1 - 1][i2 - 1])); //replace
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }


}