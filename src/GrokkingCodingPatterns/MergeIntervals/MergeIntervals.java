package GrokkingCodingPatterns.MergeIntervals;

import java.util.*;

//https://leetcode.com/problems/merge-intervals/submissions/

public class MergeIntervals {

    /*
    Problem Statement #
Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

Example 1:

Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
one [1,5].
svg viewer
Example 2:

Intervals: [[6,7], [2,4], [5,9]]
Output: [[2,4], [5,9]]
Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].

Example 3:

Intervals: [[1,4], [2,6], [3,5]]
Output: [[1,6]]
Explanation: Since all the given intervals overlap, we merged them into one.

Time complexity #
The time complexity of the above algorithm is O(N * logN)O(N∗logN), where ‘N’ is
the total number of intervals. We are iterating the intervals only once which will
take O(N)O(N), in the beginning though, since we need to sort the intervals, our algorithm will take O(N * logN)O(N∗logN).

Space complexity #
The space complexity of the above algorithm will be O(N)O(N) as we need to return
a list containing all the merged intervals. We will also need O(N)O(N) space for sorting.
For Java, depending on its version, Collection.sort() either uses Merge sort or Timsort,
and both these algorithms need O(N)O(N) space. Overall, our algorithm has a space complexity of O(N)O(N).
     */

    public static void main(String[] args) {
/*
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.println("first:");
        merge(input).stream().forEach(interval -> System.out.println(interval.getStart() + "-" + interval.getEnd()));

        System.out.println("second:");
        List<Interval> input2 = new ArrayList<>();
        input2.add(new Interval(6, 7));
        input2.add(new Interval(2, 4));
        input2.add(new Interval(5, 9));
        merge(input2).stream().forEach(interval -> System.out.println(interval.getStart() + "-" + interval.getEnd()));

        System.out.println("third:");
        List<Interval> input3 = new ArrayList<>();
        input3.add(new Interval(1, 4));
        input3.add(new Interval(2, 6));
        input3.add(new Interval(3, 5));
        merge(input3).stream().forEach(interval -> System.out.println(interval.getStart() + "-" + interval.getEnd()));
*/

        int[][] arr = {{1,4}, {5,5}, {7,9}};
        System.out.println(overlapped(arr));

    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> linkedList = new LinkedList<>();

        for (int[] internal : intervals) {
            if (linkedList.isEmpty() || linkedList.getLast()[1] < internal[0]) {
                linkedList.add(internal);
            } else {
                linkedList.getLast()[1] = Math.max(linkedList.getLast()[1], internal[1]);
            }
        }
        return linkedList.toArray(new int[linkedList.size()][]);
    }

    static class Interval {
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.setStart(start);
            this.setEnd(end);
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {

        //Collections.sort(intervals, (a, b) -> Integer.compare(a.getStart(), b.getStart()));
        //Collections.sort(intervals, Comparator.comparing(Interval::getStart));
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });


        LinkedList<Interval> linkedList = new LinkedList<>();

        for (Interval internal : intervals) {
            if (linkedList.isEmpty() || linkedList.getLast().getEnd() < internal.getStart()) {
                linkedList.add(internal);
            } else {
                linkedList.getLast().setEnd(Math.max(linkedList.getLast().getEnd(), internal.getEnd()));
            }
        }
        return linkedList;
    }

    public static boolean overlapped(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> linkedList = new LinkedList<>();

        for (int[] internal : intervals) {
            if (linkedList.isEmpty() || linkedList.getLast()[1] < internal[0]) {
                linkedList.add(internal);
            } else {
                return true;
            }
        }
        return false;
    }


}
