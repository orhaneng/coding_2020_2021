package GrokkingDynamicProgrammingPatterns;

import java.util.HashMap;
//https://leetcode.com/problems/interleaving-string/submissions/
/*
Problem Statement #
Give three strings ‘m’, ‘n’, and ‘p’, write a method to find out if ‘p’ has been formed by interleaving ‘m’ and ‘n’. ‘p’ would be considered interleaving ‘m’ and ‘n’ if it contains all the letters from ‘m’ and ‘n’ and the order of letters is preserved too.

Example 1:

Input: m="abd", n="cef", p="abcdef"
Output: true
Explanation: 'p' contains all the letters from 'm' and 'n' and preserves their order too.
Example 2:

Input: m="abd", n="cef", p="adcbef"
Output: false
Explanation: 'p' contains all the letters from 'm' and 'n' but does not preserve the order.
Example 3:

Input: m="abc", n="def", p="abdccf"
Output: false
Explanation: 'p' does not contain all the letters from 'm' and 'n'.
Example 4:

Input: m="abcdef", n="mnop", p="mnaobcdepf"
Output: true
Explanation: 'p' contains all the letters from 'm' and 'n' and preserves their order too.

 */
public class StringsInterleaving {

}

class StringsInterleavingBruteForce {
    public boolean isInterleave(String s1, String s2, String s3) {
        return help(s1, s2, s3, 0, 0, 0);
    }

    public boolean help(String s1, String s2, String s3, int id1, int id2, int id3) {
        if (s1.length() == id1 && s2.length() == id2 && s3.length() == id3) {
            return true;
        }

        if (s3.length() == id3)
            return false;

        boolean i1 = false, i2 = false;

        if (id1 < s1.length() && s1.charAt(id1) == s3.charAt(id3))
            i1 = help(s1, s2, s3, id1 + 1, id2, id3 + 1);

        if (id2 < s2.length() && s2.charAt(id2) == s3.charAt(id3))
            i2 = help(s1, s2, s3, id1, id2 + 1, id3 + 1);

        return i1 || i2;
    }
}

class StringsInterleavingTopdownDynamicProgrammingwithMemoization {

    public boolean isInterleave(String s1, String s2, String s3) {
        HashMap<String, Boolean> map = new HashMap<>();
        return help(map, s1, s2, s3, 0, 0, 0);
    }

    public boolean help(HashMap<String, Boolean> map, String s1, String s2, String s3, int id1, int id2, int id3) {
        if (s1.length() == id1 && s2.length() == id2 && s3.length() == id3) {
            return true;
        }

        if (s3.length() == id3)
            return false;

        boolean i1 = false, i2 = false;
        String key = id1 + "-" + id2 + "-" + id3;
        if (!map.containsKey(key)) {
            if (id1 < s1.length() && s1.charAt(id1) == s3.charAt(id3))
                i1 = help(map, s1, s2, s3, id1 + 1, id2, id3 + 1);

            if (id2 < s2.length() && s2.charAt(id2) == s3.charAt(id3))
                i2 = help(map, s1, s2, s3, id1, id2 + 1, id3 + 1);

            map.put(key, i1 || i2);
        }
        return map.get(key);
    }
}

class StringsInterleavingBottomupDynamicProgramming{
    public Boolean findSI(String m, String n, String p) {
        // dp[mIndex][nIndex] will be storing the result of string interleaving
        // up to p[0..mIndex+nIndex-1]
        boolean[][] dp = new boolean[m.length() + 1][n.length() + 1];

        // make sure if lengths of the strings add up
        if (m.length() + n.length() != p.length())
            return false;

        for (int mIndex = 0; mIndex <= m.length(); mIndex++) {
            for (int nIndex = 0; nIndex <= n.length(); nIndex++) {
                // if 'm' and 'n' are empty, then 'p' must have been empty too.
                if (mIndex == 0 && nIndex == 0)
                    dp[mIndex][nIndex] = true;
                    // if 'm' is empty, we need to check the interleaving with 'n' only
                else if (mIndex == 0 && n.charAt(nIndex - 1) == p.charAt(mIndex + nIndex - 1))
                    dp[mIndex][nIndex] = dp[mIndex][nIndex - 1];
                    // if 'n' is empty, we need to check the interleaving with 'm' only
                else if (nIndex == 0 && m.charAt(mIndex - 1) == p.charAt(mIndex + nIndex - 1))
                    dp[mIndex][nIndex] = dp[mIndex - 1][nIndex];
                else {
                    // if the letter of 'm' and 'p' match, we take whatever is matched till mIndex-1
                    if (mIndex > 0 && m.charAt(mIndex - 1) == p.charAt(mIndex + nIndex - 1))
                        dp[mIndex][nIndex] = dp[mIndex - 1][nIndex];
                    // if the letter of 'n' and 'p' match, we take whatever is matched till nIndex-1 too
                    // note the '|=', this is required when we have common letters
                    if (nIndex > 0 && n.charAt(nIndex - 1) == p.charAt(mIndex + nIndex - 1))
                        dp[mIndex][nIndex] |= dp[mIndex][nIndex - 1];
                }
            }
        }
        return dp[m.length()][n.length()];
    }

}