package GrokkingCodingPatterns.MergeIntervals;

//https://leetcode.com/problems/interval-list-intersections/

import java.util.ArrayList;
import java.util.List;

/*
Problem Statement #
Given two lists of intervals, find the intersection of these two lists. Each list consists of disjoint intervals sorted on their start time.

Example 1:

Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
Output: [2, 3], [5, 6], [7, 7]
Explanation: The output list contains the common intervals between the two lists.
Example 2:

Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
Output: [5, 7], [9, 10]
Explanation: The output list contains the common intervals between the two lists.

Time complexity #
As we are iterating through both the lists once, the time complexity of the above algorithm is O(N + M)O(N+M),
 where ‘N’ and ‘M’ are the total number of intervals in the input arrays respectively.

Space complexity #
Ignoring the space needed for the result list, the algorithm runs in constant space O(1)O(1).

 */
public class IntervalsIntersection {

    public static void main(String[] args) {

    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if ((A[i][0] >= B[j][0] && A[i][0] <= B[j][1]) || (A[i][0] <= B[j][0] && A[i][1] >= B[j][0])) {
                res.add(new int[]{Math.max(A[i][0],B[j][0]),Math.min(A[i][1],B[j][1])});
            }

            if(A[i][1]<B[j][1]){
                i++;
            }else{
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
