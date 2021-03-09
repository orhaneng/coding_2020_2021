package LeetcodeAmazon;

//https://leetcode.com/problems/find-median-from-data-stream/

import java.util.PriorityQueue;

public class _295FindMedianfromDataStream {

    public static void main(String[] args) {

    }

    class MedianFinder {

        /**
         * initialize your data structure here.
         */

        PriorityQueue<Integer> minheap = null;
        PriorityQueue<Integer> maxheap = null;

        public MedianFinder() {
            minheap = new PriorityQueue<>();
            maxheap = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            minheap.add(num);
            maxheap.add(minheap.poll());

            if (minheap.size() < maxheap.size()) {
                minheap.add(maxheap.poll());
            }
        }

        public double findMedian() {
            return minheap.size() > maxheap.size() ? minheap.peek() : ((double) maxheap.peek() + minheap.peek()) / 2;
        }
    }

}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

