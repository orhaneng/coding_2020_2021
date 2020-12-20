package GrokkingCodingPatterns.TwoPointers;

//https://leetcode.com/problems/3sum-smaller/

/*
Problem Statement #
Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.

Example 1:

Input: [-1, 0, 2, 3], target=3
Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
Example 2:

Input: [-1, 4, 2, 1, 3], target=5
Output: 4
Explanation: There are four triplets whose sum is less than the target:
   [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]

   TIME O(N*N)
   SPACE O(N)

 */
import java.util.Arrays;

public class TripletswithSmallerSum {

    public static void main(String[] args) {
        System.out.println(threeSumSmaller(new int[]{-1, 4, 2, 1, 3},5));
    }
    public static int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left]+nums[right]+nums[i];
                if(sum<target){
                    System.out.println(nums[left]+","+nums[right]+","+nums[i]);
                    count +=right-left;
                    left++;
                }else{
                    right--;
                }
            }
        }
        return count;
    }
}
