package GrokkingCodingPatterns.KWayMerge;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

/*

Given an N * NN∗N matrix where each row and column is sorted in ascending order, find the Kth smallest element in the matrix.

Example 1:

Input: Matrix=[
    [2, 6, 8],
    [3, 7, 10],
    [5, 8, 11]
  ],
  K=5
Output: 7
Explanation: The 5th smallest number in the matrix is 7.


Time complexity #
First, we inserted at most ‘K’ or one element from each of the ‘N’ rows, which will take O(min(K, N))O(min(K,N)).
Then we went through at most ‘K’ elements in the matrix and remove/add one element in the heap in each step.
As we can’t have more than ‘N’ elements in the heap in any condition, therefore, the overall time complexity of the
above algorithm will be O(min(K, N) + K*logN)O(min(K,N)+K∗logN).

Space complexity #
The space complexity will be O(N)O(N) because, in the worst case, our min-heap will be storing one number from each of the ‘N’ rows.

 */


import java.util.PriorityQueue;

public class KthSmallestNumberinaSortedMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                {2, 6, 8},
                {3, 7, 10},
                {5, 8, 11}
        };
        System.out.println(kthSmallest(matrix, 5));
    }

    public static class Node {
        int rowindex;
        int colindex;

        Node(int rowindex, int colindex) {
            this.rowindex = rowindex;
            this.colindex = colindex;
        }
    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> matrix[a.rowindex][a.colindex] - matrix[b.rowindex][b.colindex]);

        for (int i = 0; i < matrix.length && i < k; i++) {
            minHeap.add(new Node(i, 0));
        }

        int count = 0;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            count++;
            if (count == k) {
                return matrix[node.rowindex][node.colindex];
            }
            node.colindex++;
            if (node.colindex < matrix[0].length) {
                minHeap.add(node);
            }
        }
        return -1;
    }
}
