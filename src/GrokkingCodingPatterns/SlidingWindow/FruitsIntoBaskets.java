package GrokkingCodingPatterns.SlidingWindow;

import java.util.HashMap;

public class FruitsIntoBaskets {
    public static void main(String[] args) {
        System.out.println(fruitsIntoBaskets(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }

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

}

