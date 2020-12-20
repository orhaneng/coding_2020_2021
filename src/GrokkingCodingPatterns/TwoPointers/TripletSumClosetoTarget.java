package GrokkingCodingPatterns.TwoPointers;

import java.util.Arrays;
//https://leetcode.com/problems/3sum-closest/
/*
Problem Statement #
Given an array of unsorted numbers and a target number,
find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet.
If there are more than one such triplet, return the sum of the triplet with the smallest sum.

Example 1:

Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
Example 2:

Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
Example 3:

Input: [1, 0, 1, 1], target=100
Output: 3
Explanation: The triplet [1, 1, 1] has the closest sum to the target.

Time complexity #
Sorting the array will take O(N* logN)O(N∗logN). Overall searchTriplet() will take O(N * logN + N^2)O(N∗logN+N
​2
​​ ), which is asymptotically equivalent to O(N^2)O(N
​2
​​ ).

Space complexity #
The space complexity of the above algorithm will be O(N)O(N) which is required for sorting.
 */
public class TripletSumClosetoTarget {

    public static void main(String[] args) {

        System.out.println(threeSumClosest(new int[]{1, 1, -1}, 0));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-1; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int diff= target - nums[left] - nums[right] - nums[i];
                if (diff == 0) {
                    return target - diff;
                }
                if(Math.abs(diff)<Math.abs(min)) min = diff;
                if(diff>0) left++;
                else right--;
            }
        }
        return target - min;
    }

}
