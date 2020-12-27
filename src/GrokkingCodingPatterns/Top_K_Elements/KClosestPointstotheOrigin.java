package GrokkingCodingPatterns.Top_K_Elements;

//https://leetcode.com/problems/k-closest-points-to-origin/

/*

Problem Statement #
Given an array of points in the a 2D2D plane, find ‘K’ closest points to the origin.

Example 1:

Input: points = [[1,2],[1,3]], K = 1
Output: [[1,2]]
Explanation: The Euclidean distance between (1, 2) and the origin is sqrt(5).
The Euclidean distance between (1, 3) and the origin is sqrt(10).
Since sqrt(5) < sqrt(10), therefore (1, 2) is closer to the origin.
Example 2:

Input: point = [[1, 3], [3, 4], [2, -1]], K = 2
Output: [[1, 3], [2, -1]]


Time complexity #
The time complexity of this algorithm is (N*logK)(N∗logK) as we iterating all points and pushing them into the heap.

Space complexity #
The space complexity will be O(K) because we need to store ‘K’ point in the heap.


 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointstotheOrigin {
    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};

        Arrays.stream(kClosest(points, 2)).forEach(e -> System.out.print(e[0] + "," + e[1] + "-"));
    }

    public static class Point {
        int[] point;
        double distance;

        Point(int[] point) {
            this.point = point;
            this.distance = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
        }
    }

    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> maxheap = new PriorityQueue<>((a, b) -> Double.compare(b.distance, a.distance));
        for (int[] point : points) {
            maxheap.offer(new Point(point));
            if (maxheap.size() > K)
                maxheap.poll();
        }

        int[][] res = new int[K][];
        int i = 0;
        while (!maxheap.isEmpty()) {
            res[i++] = maxheap.poll().point;
        }
        return res;
    }

}
