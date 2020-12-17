package GrokkingCodingPatterns.SlidingWindow;

import java.util.HashMap;
/*
Problem Statement #
Given a string, find the length of the longest substring which has no repeating characters.

Example 1:

Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".
Example 2:

Input: String="abbbb"
Output: 2
Explanation: The longest substring without any repeating characters is "ab".
Example 3:

Input: String="abccde"
Output: 3
Explanation: Longest substrings without any repeating characters are "abc" & "cde".

 */
public class NoRepeatSubstring {


    public static void main(String[] args) {
        System.out.println(noRepeatSubstring("abccde"));
    }

    public static int noRepeatSubstring(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0;
        int max = 0;
        for (int end = 0; end < str.length(); end++) {
            if (map.containsKey(str.charAt(end))) {
                int index = map.get(str.charAt(end));
                start = index + 1;
            } else {
                max = Math.max(max, end - start + 1);
                map.put(str.charAt(end), end - start);
            }
        }
        return max;
    }
}
    /*
    Time Complexity #
        The time complexity of the above algorithm will be O(N)O(N) where ‘N’ is the number of characters in the input string.

    Space Complexity #
        The space complexity of the algorithm will be O(K)O(K) where KK is the number of distinct characters in the input string.
        This also means K<=NK<=N, because in the worst case, the whole string might not have any repeating character so the entire
        string will be added to the HashMap. Having said that, since we can expect a fixed set of characters in the input string
        (e.g., 26 for English letters), we can say that the algorithm runs in fixed space O(1)O(1); in this case, we can use a
        fixed-size array instead of the HashMap.
     */