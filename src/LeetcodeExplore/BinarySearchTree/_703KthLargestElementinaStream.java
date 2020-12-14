package LeetcodeExplore.BinarySearchTree;
//https://leetcode.com/problems/kth-largest-element-in-a-stream/


import java.util.PriorityQueue;

public class _703KthLargestElementinaStream {

    class KthLargest {
        PriorityQueue<Integer> queue;
        int k;

        public KthLargest(int k, int[] a) {
            this.k = k;
            queue = new PriorityQueue<>(k);
            for (int item : a) add(item);
        }

        public int add(int n) {
            if (queue.size() < k) queue.offer(n);
            else if (queue.peek() > n) {
                queue.poll();
                queue.offer(n);
            }
            return queue.peek();
        }
    }
}
