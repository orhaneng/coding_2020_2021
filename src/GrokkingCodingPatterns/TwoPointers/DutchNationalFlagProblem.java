package GrokkingCodingPatterns.TwoPointers;

import java.util.Arrays;

//https://leetcode.com/problems/sort-colors/
/*
Problem Statement #
Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects,
hence, we can’t count 0s, 1s, and 2s to recreate the array.

The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists
of three different numbers that is why it is called Dutch National Flag problem.

Example 1:

Input: [1, 0, 2, 1, 0]
Output: [0 0 1 1 2]
Example 2:

Input: [2, 2, 0, 1, 2, 0]
Output: [0 0 1 2 2 2 ]

Time complexity #
The time complexity of the above algorithm will be O(N)O(N) as we are iterating the input array only once.

Space complexity #
The algorithm runs in constant space O(1)O(1).

 */
public class DutchNationalFlagProblem {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1;
        for (int i = 0; i <= high;) {
            if (nums[i] == 0) {
                swap(nums, i++, low++);

            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, high--);
            }
        }
    }

    public static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
