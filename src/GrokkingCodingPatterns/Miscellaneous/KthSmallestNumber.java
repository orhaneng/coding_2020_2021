package GrokkingCodingPatterns.Miscellaneous;

import java.util.PriorityQueue;

public class KthSmallestNumber {
    public static void main(String[] args) {
        int[] nums = {5, 12, 11, -1, 12};
        System.out.println(kthSmallestNumber(nums,3));
     }

     /*
     Time & Space Complexity #
        The time complexity of the above algorithm is O(K*logK + (N-K)*logK)O(K∗logK+(N−K)∗logK)
        which is asymptotically equal to O(N*logK)O(N∗logK). The space complexity will be O(K)O(K)
        because we need to store ‘K’ smallest numbers in the heap.
      */
    public static int kthSmallestNumber(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            maxHeap.add(num);
            if(maxHeap.size()>k)
                maxHeap.poll();
        }

        return maxHeap.peek();
    }
}
