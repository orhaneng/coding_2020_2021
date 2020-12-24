package GrokkingCodingPatterns.CyclicSort;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

/*
Problem Statement #
We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.

Example 1:

Input: [2, 3, 1, 8, 2, 3, 5, 1]
Output: 4, 6, 7
Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
Example 2:

Input: [2, 4, 1, 2]
Output: 3
Example 3:

Input: [2, 3, 2, 1]
Output: 4

Time complexity #
The time complexity of the above algorithm is O(n).

Space complexity #
Ignoring the space required for the output array, the algorithm runs in constant space O(1).

Mark as Completed

 */
import java.util.ArrayList;
import java.util.List;

public class FindallMissingNumbers {

    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{1, 4, 4, 3, 2}).stream().forEach(System.out::println);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
            else{
                i++;
            }
        }


        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                list.add(j + 1);
            }
        }
        return list;

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
