package GrokkingCodingPatterns.TopologicalSortGraph;

import java.util.*;

public class AlienDictionary {

    /*
    Problem Statement #
There is a dictionary containing words from an alien language for which we don’t know the ordering of the characters.
Write a method to find the correct order of characters in the alien language.

Example 1:

Input: Words: ["ba", "bc", "ac", "cab"]
Output: bac
Explanation: Given that the words are sorted lexicographically by the rules of the alien language, so
from the given words we can conclude the following ordering among its characters:

1. From "ba" and "bc", we can conclude that 'a' comes before 'c'.
2. From "bc" and "ac", we can conclude that 'b' comes before 'a'

From the above two points, we can conclude that the correct character order is: "bac"


     */
    public static void main(String[] args) {
        System.out.println(findOrder(new String[]{"ba", "bc", "ac", "cab"}));
    }

    /*
    Time complexity #
In step ‘d’, each task can become a source only once and each edge (a rule) will be accessed and removed once.
Therefore, the time complexity of the above algorithm will be O(V+E)O(V+E), where ‘V’ is the total number of different
 characters and ‘E’ is the total number of the rules in the alien language. Since, at most, each pair of words can give
 us one rule, therefore, we can conclude that the upper bound for the rules is O(N)O(N) where ‘N’ is the number of words
  in the input. So, we can say that the time complexity of our algorithm is O(V+N)O(V+N).

Space complexity #
The space complexity will be O(V+N)O(V+N), since we are storing all of the rules for each character in an adjacency list.


     */
    public static String findOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        HashMap<Character, Integer> inDegree = new HashMap<>();
        HashMap<Character, List<Character>> graph = new HashMap<>();
        for (String word : words) {
            for (char character : word.toCharArray()) {
                inDegree.put(character, 0);
                graph.put(character, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char parent = w1.charAt(j), child = w2.charAt(j);
                if (parent != child) {
                    graph.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child) + 1);
                    break;
                }
            }
        }

        Queue<Character> sources = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        StringBuilder sortedOrder = new StringBuilder();
        while (!sources.isEmpty()) {
            Character vertex = sources.poll();
            sortedOrder.append(vertex);
            List<Character> children = graph.get(vertex);
            for (Character child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }
        if (sortedOrder.length() != inDegree.size()) {
            return "";
        }
        return sortedOrder.toString();
    }
}
