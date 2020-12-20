package GrokkingCodingPatterns.SlidingWindow;
//https://leetcode.com/problems/fruit-into-baskets/

import java.util.HashMap;

public class FruitsIntoBaskets {
    public static void main(String[] args) {
        //System.out.println(fruitsIntoBaskets(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
        System.out.println(totalFruit(new int[]{4, 1, 1, 1, 3, 1, 7, 5}));
    }

    /*
    Problem Statement #
    Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put
    maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

    You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e.,
    you will stop when you have to pick from a third fruit type.

    Write a function to return the maximum number of fruits in both the baskets.

    Example 1:
        Input: Fruit=['A', 'B', 'C', 'A', 'C']
        Output: 3
        Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
    Example 2:
        Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
        Output: 5
        Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
        This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']

     */
    /*
        The time complexity of the above algorithm will be O(N)O(N) where ‘N’ is the number of characters in the input array.
        The outer for loop runs for all characters and the inner while loop processes each character only once,
        therefore the time complexity of the algorithm will be O(N+N)O(N+N) which is asymptotically equivalent to O(N)O(N).

        Space Complexity #
        The algorithm runs in constant space O(1)O(1) as there can be a maximum of three types of fruits stored in the frequency map.
    */

    public static int fruitsIntoBaskets(char[] fruits) {
        if (fruits.length == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0;
        int max = 0;
        for (int end = 0; end < fruits.length; end++) {
            char ch = fruits[end];
            int localmax = max;
            while (map.keySet().size() >= 2 && !map.containsKey(ch)) {
                char rem = fruits[start];
                if (map.containsKey(fruits[start])) {
                    int count = map.get(fruits[start]);
                    count--;
                    localmax--;
                    if (count == 0) {
                        map.remove(fruits[start]);
                    } else {
                        map.put(rem, count);
                    }
                    start++;
                } else {
                    break;
                }
            }
            localmax++;
            max = Math.max(max, localmax);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return max;

    }

    public static int totalFruit(int[] tree) {
        if (tree.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0, max = 0;
        for (int end = 0; end < tree.length; end++) {
            int ch = tree[end];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.keySet().size() > 2) {
                int rem = tree[start++];
                map.put(rem, map.get(rem) - 1);
                map.remove(rem, 0);
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}



