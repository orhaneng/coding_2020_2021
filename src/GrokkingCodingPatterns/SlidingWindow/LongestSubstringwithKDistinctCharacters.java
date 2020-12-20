package GrokkingCodingPatterns.SlidingWindow;

import java.util.HashMap;

//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

public class LongestSubstringwithKDistinctCharacters {

    public static void main(String[] args) {
        System.out.println(longestSubstringwithKDistinctCharacters("aa", 2));
    }
    /*
        Example 1:

        Input: String="araaci", K=2
        Output: 4
        Explanation: The longest substring with no more than '2' distinct characters is "araa".
        Example 2:

        Input: String="araaci", K=1
        Output: 2
        Explanation: The longest substring with no more than '1' distinct characters is "aa".
        Example 3:

        Input: String="cbbebi", K=3
        Output: 5
        Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
    */
    /*
    Time Complexity #
        The time complexity of the above algorithm will be O(N)O(N) where ‘N’ is the number of characters in the input string.
        The outer for loop runs for all characters and the inner while loop processes each character only once,
        therefore the time complexity of the algorithm will be O(N+N)O(N+N) which is asymptotically equivalent to O(N)O(N).
    Space Complexity #
        The space complexity of the algorithm is O(K)O(K), as we will be storing a maximum of ‘K+1’ characters in the HashMap.
     */

    public static int longestSubstringwithKDistinctCharacters(String text, int k) {
        if (text == null) return 0;

        HashMap<Character, Integer> set = new HashMap<>();

        int start = 0;
        int max = 0;
        for (int end = 0; end < text.length(); end++) {
            char ch = text.charAt(end);
            set.put(ch, set.getOrDefault(ch, 0) + 1);
            while (set.keySet().size() > k ) {
                char rem = text.charAt(start++);
                set.put(rem, set.get(rem) - 1);
                if (set.get(rem) == 0) {
                    set.remove(rem);
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
