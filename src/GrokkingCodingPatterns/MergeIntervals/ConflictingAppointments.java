package GrokkingCodingPatterns.MergeIntervals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Problem Statement #
Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.

Example 1:

Appointments: [[1,4], [2,5], [7,9]]
Output: false
Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
Example 2:

Appointments: [[6,7], [2,4], [8,12]]
Output: true
Explanation: None of the appointments overlap, therefore a person can attend all of them.
Example 3:

Appointments: [[4,5], [2,3], [3,6]]
Output: false
Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.


Time complexity #
The time complexity of the above algorithm is O(N*logN)O(N∗logN), where ‘N’ is the total number of appointments.
Though we are iterating the intervals only once, our algorithm will take O(N * logN)O(N∗logN) since we need to sort them in the beginning.

Space complexity #
The space complexity of the above algorithm will be O(N)O(N), which we need for sorting. For Java, Arrays.sort() uses
Timsort, which needs O(N)O(N) space.


 */
public class ConflictingAppointments {


    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static boolean canAttendAllAppointments(Interval[] intervals){

        Arrays.sort(intervals, (a,b)->Integer.compare(a.start,b.start));
        for (int i = 1; i <intervals.length ; i++) {
            if(intervals[i].start< intervals[i-1].end) return false;
        }

        return true;
    }
}
