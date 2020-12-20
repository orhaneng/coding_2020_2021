package GrokkingCodingPatterns.TwoPointers;

//https://leetcode.com/problems/3sum/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Statement #
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

Example 1:

Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.
Example 2:

Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.

Time complexity #
Sorting the array will take O(N * logN)O(N∗logN). The searchPair() function will take O(N)O(N).
As we are calling searchPair() for every number in the input array, this means that overall searchTriplets()
will take O(N * logN + N^2)O(N∗logN+N
​2
​​ ), which is asymptotically equivalent to O(N^2)O(N
​2
​​ ).

Space complexity #
Ignoring the space required for the output array, the space complexity of the above algorithm will be O(N)O(N) which is required for sorting.
 */
public class TripletSumtoZero {

    public static void main(String[] args) {
        threeSum(new int[]{-3, 0, 1, 2, -1, 1, -2}).stream().forEach(System.out::println);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            help(nums, -nums[i], i + 1, res);
        }
        return res;
    }

    public static void help(int[] nums, int target, int left, List<List<Integer>> res) {
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                res.add(Arrays.asList(-target, nums[left], nums[right]));
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) left++;
                while (left < right && nums[right] == nums[right + 1]) right--;
            } else if (sum > target)
                right--;
            else
                left++;
        }
    }


}