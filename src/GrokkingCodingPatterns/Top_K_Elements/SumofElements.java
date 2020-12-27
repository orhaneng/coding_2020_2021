package GrokkingCodingPatterns.Top_K_Elements;

import java.util.PriorityQueue;

/*

Problem Statement #
Given an array, find the sum of all numbers between the K1’th and K2’th smallest elements of that array.

Example 1:

Input: [1, 3, 12, 5, 15, 11], and K1=3, K2=6
Output: 23
Explanation: The 3rd smallest number is 5 and 6th smallest number 15. The sum of numbers coming
between 5 and 15 is 23 (11+12).
Example 2:

Input: [3, 5, 8, 7], and K1=1, K2=4
Output: 12
Explanation: The sum of the numbers between the 1st smallest number (3) and the 4th smallest
number (8) is 12 (5+7).

Time complexity #

Since we need to put only the top K2 numbers in the max-heap at any time,
the time complexity of the above algorithm will be O(N*logK2)O(N∗logK2).

Space complexity #
The space complexity will be O(K2)O(K2), as we need to store the smallest ‘K2’ numbers in the heap.

Mark as Completed



 */

public class SumofElements {

    public static void main(String[] args) {
        System.out.println(findSumOfElements(new int[]{3, 5, 8, 7},1,4));
    }

    public static int findSumOfElements(int[] nums, int k1, int k2){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num:nums)
            minHeap.offer(num);

        int sum =0;

        while (!minHeap.isEmpty()){
            int val = minHeap.poll();
            k1--;
            k2--;
            if(k1<0 && k2>0)
                sum += val;
        }
        return sum;
    }
}
