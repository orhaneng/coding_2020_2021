package GrokkingCodingPatterns.Top_K_Elements;

import java.util.PriorityQueue;

/*
Problem Statement #
Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost.
The cost of connecting two ropes is equal to the sum of their lengths.

Example 1:

Input: [1, 3, 11, 5]
Output: 33
Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)
Example 2:

Input: [3, 4, 5, 6]
Output: 36
Explanation: First connect 3+4(=7), then 5+6(=11), 7+11(=18). Total cost is 36 (7+11+18)
Example 3:

Input: [1, 3, 11, 5, 2]
Output: 42
Explanation: First connect 1+2(=3), then 3+3(=6), 6+5(=11), 11+11(=22). Total cost is 42 (3+6+11+22)


Time complexity #
Given ‘N’ ropes, we need O(N*logN)O(N∗logN) to insert all the ropes in the heap. In each step,
while processing the heap, we take out two elements from the heap and insert one.
This means we will have a total of ‘N’ steps, having a total time complexity of O(N*logN)O(N∗logN).

Space complexity #
The space complexity will be O(N)O(N) because we need to store all the ropes in the heap.


 */
public class ConnectRopes {

    public static void main(String[] args) {
        System.out.println(minimumCostToConnectRopes(new int[]{1, 3, 11, 5}));
    }

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        int sum = 0;
        for (int rope : ropeLengths) {
            minHeap.offer(rope);
        }
        while (minHeap.size() > 1) {
            int subsum = minHeap.poll() + minHeap.poll();
            minHeap.offer(subsum);
            sum += subsum;
        }
        return sum;
    }
}
