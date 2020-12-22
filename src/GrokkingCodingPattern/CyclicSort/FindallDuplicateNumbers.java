package GrokkingCodingPattern.CyclicSort;

//https://leetcode.com/problems/find-all-duplicates-in-an-array/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindallDuplicateNumbers {

    /*
    Problem Statement #
    We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
    The array has some duplicates, find all the duplicate numbers without using any extra space.

    Example 1:

    Input: [3, 4, 4, 5, 5]
    Output: [4, 5]
    Example 2:

    Input: [5, 4, 7, 2, 3, 5, 3]
    Output: [3, 5]

    Time complexity #
    The time complexity of the above algorithm is O(n)O(n).

    Space complexity #
    Ignoring the space required for storing the duplicates, the algorithm runs in constant space O(1)O(1).

     */

    public static void main(String[] args) {
        findDuplicates(new int[]{3, 4, 4, 5, 5}).forEach(System.out::println);
    }


    public static List<Integer> findDuplicates(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);

            } else {
                i++;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                list.add(nums[j]);
            }
        }
        return list;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*    public static List<Integer> findDuplicates(int[] nums) {

            List<Integer> list = new ArrayList<>();

            int i = 0;
            while (i < nums.length) {
                if (nums[i] != i + 1 && !list.contains(nums[i])) {
                    if (nums[i] != nums[nums[i] - 1]) {
                        swap(nums, i, nums[i] - 1);
                    } else {
                        list.add(nums[i]);
                    }
                } else {
                    i++;
                }
            }
            return list;
        }*/

}


