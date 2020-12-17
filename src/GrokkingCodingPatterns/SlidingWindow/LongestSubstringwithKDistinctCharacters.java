package GrokkingCodingPatterns.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringwithKDistinctCharacters {

    public static void main(String[] args) {
        System.out.println(longestSubstringwithKDistinctCharacters("cbbebi",3   ));
    }

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
            int localmax= max;
            while (set.keySet().size() >= k && !set.containsKey(ch)) {
                char rem = text.charAt(start++);
                if (set.containsKey(rem)) {
                    int count = set.get(rem);
                    count--;
                    localmax--;
                    if (count == 0) {
                        set.remove(rem);
                    } else {
                        set.put(rem, count);
                    }
                }else{
                    break;
                }
            }
            localmax++;
            max = Math.max(max,localmax);
            set.put(ch, set.getOrDefault(ch, 0) + 1);
        }
        return max;

    }

}
