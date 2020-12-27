package GrokkingCodingPatterns.Top_K_Elements;

//https://leetcode.com/problems/sort-characters-by-frequency/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/*

Problem Statement #
Given a string, sort it based on the decreasing frequency of its characters.

Example 1:

Input: "Programming"
Output: "rrggmmPiano"
Explanation: 'r', 'g', and 'm' appeared twice, so they need to appear before any other character.
Example 2:

Input: "abcbab"
Output: "bbbaac"
Explanation: 'b' appeared three times, 'a' appeared twice, and 'c' appeared only once.


Time complexity #
The time complexity of the above algorithm is O(D*logD)O(D∗logD) where ‘D’ is the number of distinct characters in
the input string. This means, in the worst case, when all characters are unique the time complexity of the algorithm
will be O(N*logN)O(N∗logN) where ‘N’ is the total number of characters in the string.

Space complexity #
The space complexity will be O(N)O(N), as in the worst case, we need to store all the ‘N’ characters in the HashMap.

 */
public class FrequencySort {

    public static void main(String[] args) {

    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char item : s.toCharArray()) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(map.entrySet());

        StringBuilder string = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i <entry.getValue() ; i++) {
                string.append(entry.getKey());
            }
        }
        return string.toString();
    }
}
