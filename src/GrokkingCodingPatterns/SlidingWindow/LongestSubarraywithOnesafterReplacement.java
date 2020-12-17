package GrokkingCodingPatterns.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Problem Statement #
Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.

Example 1:

Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
Example 2:

Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
Output: 9
Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.

https://leetcode.com/problems/max-consecutive-ones-iii/solution/


 */
public class LongestSubarraywithOnesafterReplacement {
    public static void main(String[] args) {
        System.out.println(longestSubarraywithOnesafterReplacement(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1},3));
    }

    public static int longestSubarraywithOnesafterReplacement(int[] arr, int k) {

        int begin = 0;
        int max = 0;
         int maxcountones=0;

        for (int end = 0; end < arr.length; end++) {
            int ch = arr[end];
            if(ch==1) maxcountones++;
            if (end - begin + 1 - maxcountones > k) {
                int left = arr[begin];
                if(left==1) maxcountones--;
                begin++;
            }
            max = Math.max(end - begin + 1, max);
        }
        return max;
    }
}
