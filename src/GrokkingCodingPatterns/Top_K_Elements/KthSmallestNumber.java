package GrokkingCodingPatterns.Top_K_Elements;

import java.util.PriorityQueue;

/*

Problem Statement #
Given an unsorted array of numbers, find Kth smallest number in it.

Please note that it is the Kth smallest number in the sorted order, not the Kth distinct element.

Note: For a detailed discussion about different approaches to solve this problem, take a look at Kth Smallest Number.

Example 1:

Input: [1, 5, 12, 2, 11, 5], K = 3
Output: 5
Explanation: The 3rd smallest number is '5', as the first two smaller numbers are [1, 2].
Example 2:

Input: [1, 5, 12, 2, 11, 5], K = 4
Output: 5
Explanation: The 4th smallest number is '5', as the first three small numbers are [1, 2, 5].
Example 3:

Input: [5, 12, 11, -1, 12], K = 3
Output: 11
Explanation: The 3rd smallest number is '11', as the first two small numbers are [5, -1].


Time complexity #
    The time complexity of this algorithm is O(K*logK+(N-K)*logK)O(K∗logK+(N−K)∗logK),
    which is asymptotically equal to O(N*logK)O(N∗logK)

Space complexity #
    The space complexity will be O(K)O(K) because we need to store ‘K’ smallest numbers in the heap.


 */
public class KthSmallestNumber {
    public static void main(String[] args) {
        //System.out.println(findKthSmallestElement(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        //1,2,3,4,5
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        System.out.println(queue.peek());
        //System.out.println(queue.poll());
        //System.out.println(queue.poll());
    }


   public static int findKthSmallestElement(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            queue.add(num);
            //if (queue.size() > k)
                queue.poll();
        }
       System.out.println(queue.peek());
        return queue.poll();
    }

/*    public static int findKthSmallestElement(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);

        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] < queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }*/

}
