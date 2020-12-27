package GrokkingCodingPatterns.TwoHeaps;


//https://leetcode.com/problems/find-median-from-data-stream/submissions/


import java.util.PriorityQueue;

public class FindtheMedianofaNumberStream {
    /*
    Problem Statement #
        Design a class to calculate the median of a number stream. The class should have the following two methods:

        insertNum(int num): stores the number in the class
        findMedian(): returns the median of all numbers inserted in the class
        If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.

        Example 1:

        1. insertNum(3)
        2. insertNum(1)
        3. findMedian() -> output: 2
        4. insertNum(5)
        5. findMedian() -> output: 3
        6. insertNum(4)
        7. findMedian() -> output: 3.5



        Time complexity #
            The time complexity of the insertNum() will be O(logN)O(logN) due to the insertion in the heap.
            The time complexity of the findMedian() will be O(1)O(1) as we can find the median from the top elements of the heaps.

        Space complexity #
            The space complexity will be O(N)O(N) because, as at any time, we will be storing all the numbers.



     */

}

class MedianFinder {

    /**
     * initialize your data structure here.
     */
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;

    public MedianFinder() {
        maxheap = new PriorityQueue<>((a, b) -> b - a);
        minheap = new PriorityQueue<>((a, b) -> a - b);

    }

    public void addNum(int num) {
        if (maxheap.isEmpty() || maxheap.peek() >= num) {
            maxheap.add(num);
        } else {
            minheap.add(num);
        }

        if (maxheap.size() > minheap.size() + 1) {
            minheap.add(maxheap.poll());
        } else if (maxheap.size() < minheap.size()) {
            maxheap.add(minheap.poll());
        }
    }

    public double findMedian() {
        if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) / 2.0;
        }
        return maxheap.peek();
    }
}
