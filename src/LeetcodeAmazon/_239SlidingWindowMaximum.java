package LeetcodeAmazon;

//https://leetcode.com/problems/sliding-window-maximum/

import java.util.*;

public class _239SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1, -1};
        int k = 1;
        Arrays.stream(maxSlidingWindow(nums, k)).forEach(System.out::println);

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0)
            return nums;

        int[] res = new int[n - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peek() < i - k + 1)
                deque.poll();

            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deque.peek()];
            }
        }

        return res;
    }

/*

TIME OLOGK

public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b)->b-a);
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {

            if (maxheap.size() == k) {
                res[i-k]=maxheap.peek();
            }
            maxheap.add(nums[i]);
            if (maxheap.size() > k) {
                maxheap.remove(nums[i - k]);
            }
        }
        res[nums.length-k]=maxheap.peek();
        return res;
    }*/

}
