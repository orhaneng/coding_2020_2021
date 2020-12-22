package GrokkingCodingPatterns.MergeIntervals;

//https://leetcode.com/problems/insert-interval/submissions/

/*
Problem Statement #
Given a list of non-overlapping intervals sorted by their start time,
insert a given interval at the correct position and merge all necessary
intervals to produce a list that has only mutually exclusive intervals.

Example 1:

Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
Output: [[1,3], [4,7], [8,12]]
Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
Example 2:

Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
Output: [[1,3], [4,12]]
Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
Example 3:

Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
Output: [[1,4], [5,7]]
Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them into one [1,4].

As we are iterating through all the intervals only once, the time complexity of the above algorithm is O(N)O(N),
where ‘N’ is the total number of intervals.

Space complexity #
The space complexity of the above algorithm will be O(N)O(N) as we need to return a list containing all the merged intervals.

 */
import java.util.Arrays;
import java.util.LinkedList;

public class InsertInterval {
    public static void main(String[] args) {

        int[][] arr = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] add = {4, 8};
        Arrays.stream(insert(arr, add)).forEach(e -> System.out.println(e[0] + "-" + e[1]));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) return new int[][]{newInterval};

        LinkedList<int[]> linkedList = new LinkedList<>();

        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            linkedList.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval = new int[]{Math.min(newInterval[0], intervals[i][0]), Math.max(newInterval[1], intervals[i][1])};
            i++;
        }
        linkedList.add(newInterval);

        while (i < intervals.length) linkedList.add(intervals[i++]);

        return linkedList.toArray(new int[linkedList.size()][2]);

    }

}
