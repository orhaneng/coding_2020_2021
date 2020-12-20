package GrokkingCodingPatterns.SlidingWindow;

//https://leetcode.com/problems/longest-repeating-character-replacement/

import java.util.HashMap;
import java.util.Map;

/*
Longest Substring with Same Letters after Replacement (hard)
Problem Statement
Try it yourself
Solution
Code
Time Complexity
Space Complexity
Problem Statement #
Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

Example 1:

Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
Example 2:

Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
Example 3:

Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".

 */
public class LongestSubstringwithSameLettersafterReplacement {

    public static void main(String[] args) {
        System.out.println(longestSubstringwithSameLettersafterReplacement("aabcde",2));
    }

    public static int longestSubstringwithSameLettersafterReplacement(String str, int k) {
        int begin = 0, maxLength = 0, maxRepeatCount = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int end = 0; end < str.length(); end++) {//0,1,2,3,4
            char ch = str.charAt(end);//C
            map.put(ch, map.getOrDefault(ch, 0) + 1);//a:1,b:1,c:2
            maxRepeatCount = Math.max(maxRepeatCount, map.get(ch));//2

            if (end - begin + 1 - maxRepeatCount > k) {//F,F,F,F,T
                char left = str.charAt(begin);//a
                map.put(left, map.get(left) - 1);
                begin++;//1
            }
            maxLength = Math.max(maxLength, end - begin + 1);//1,2,3,4
        }
        return maxLength;

    }
}

