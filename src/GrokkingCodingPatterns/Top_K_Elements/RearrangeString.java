package GrokkingCodingPatterns.Top_K_Elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/reorganize-string/

public class RearrangeString {


    /*
    Problem Statement #
        Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other.

    Example 1:

    Input: "aappp"
    Output: "papap"
    Explanation: In "papap", none of the repeating characters come next to each other.
    Example 2:

    Input: "Programming"
    Output: "rgmrgmPiano" or "gmringmrPoa" or "gmrPagimnor", etc.
    Explanation: None of the repeating characters come next to each other.
    Example 3:

    Input: "aapa"
    Output: ""
    Explanation: In all arrangements of "aapa", atleast two 'a' will come together e.g., "apaa", "paaa".

     */
    public static void main(String[] args) {
        System.out.println(reorganizeString("vvvlo"));
    }

    public static String reorganizeString(String S) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : S.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(map.entrySet());

        StringBuilder stringBuilder = new StringBuilder();

        Map.Entry<Character, Integer> prevEntry = null;

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();

            if (prevEntry != null && prevEntry.getValue() > 0)
                maxHeap.offer(prevEntry);
            stringBuilder.append(entry.getKey());

            entry.setValue(entry.getValue() - 1);
            prevEntry = entry;
        }

        return stringBuilder.length() == S.length() ? stringBuilder.toString() : "";
    }


}
