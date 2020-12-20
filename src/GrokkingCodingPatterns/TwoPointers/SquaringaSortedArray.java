package GrokkingCodingPatterns.TwoPointers;

//https://leetcode.com/problems/squares-of-a-sorted-array/
/*
Problem Statement #
Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

Example 1:

Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]
Example 2:

Input: [-3, -1, 0, 1, 2]
Output: [0 1 1 4 9]

Time complexity #
The time complexity of the above algorithm will be O(N) as we are iterating the input array only once.

Space complexity #
The space complexity of the above algorithm will also be O(N); this space will be used for the output array.

 */

import java.util.Arrays;

public class SquaringaSortedArray {

    public static void main(String[] args) {
        Arrays.stream(squaringaSortedArray(new int[]{-2, -1, 0, 2, 3})).forEach(System.out::println);
    }

    public static int[] squaringaSortedArray(int[] arr) {

        int[] res = new int[arr.length];

        int right = arr.length - 1, left = 0, indes = arr.length - 1;

        while (left <= right) {
            int rightsquare = arr[right] * arr[right];
            int leftsquare = arr[left] * arr[left];
            if (leftsquare > rightsquare) {
                res[indes--] = leftsquare;
                left++;
            } else {
                res[indes--] = rightsquare;
                right--;
            }
        }
        return res;

    }
}
