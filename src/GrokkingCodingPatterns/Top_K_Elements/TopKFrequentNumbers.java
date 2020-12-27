package GrokkingCodingPatterns.Top_K_Elements;

//https://leetcode.com/problems/top-k-frequent-elements/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*


Problem Statement #
Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.

Example 1:

Input: [1, 3, 5, 12, 11, 12, 11], K = 2
Output: [12, 11]
Explanation: Both '11' and '12' apeared twice.
Example 2:

Input: [5, 12, 11, 3, 11], K = 2
Output: [11, 5] or [11, 12] or [11, 3]
Explanation: Only '11' appeared twice, all other numbers appeared once.



Time complexity #
The time complexity of the above algorithm is O(N+N*logK)O(N+N∗logK).

Space complexity #
The space complexity will be O(N)O(N). Even though we are storing only ‘K’ numbers in the heap.
For the frequency map, however, we need to store all the ‘N’ numbers.



 */
public class TopKFrequentNumbers {
    public static void main(String[] args) {

    }


    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            maxHeap.offer(entry);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[] res = new int[k];

        int i = 0;
        while (!maxHeap.isEmpty()) {
            res[i++] = maxHeap.poll().getKey();
        }
        return res;
    }
}
