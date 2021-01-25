package GrokkingCodingPatterns.TwoPointers;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/solution/

/*
Problem Statement #
Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space;
after removing the duplicates in-place return the new length of the array.

Example 1:

Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
Example 2:

Input: [2, 2, 2, 11]
Output: 2
Explanation: The first two elements after removing the duplicates will be [2, 11].
Try it yourself #

 */
public class RemoveDuplicates {

    /*
    Time Complexity #
The time complexity of the above algorithm will be O(N)O(N), where ‘N’ is the total number of elements in the given array.

Space Complexity #
The algorithm runs in constant space O(1)O(1).
     */
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{2, 3, 3, 3, 6, 9, 9}));
    }

    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return -1;
        int slow = 0;
        int fast = 1;
        while (fast < arr.length) {
            if (arr[slow] < arr[fast]) {
                arr[++slow] = arr[fast];
                fast++;
            } else {
                fast++;
            }
        }
        return slow + 1;
    }

    public static int removeDuplicates2(int[] arr) {
            if (arr.length == 0) return -1;
            int slow=1;
            for (int fast = 0; fast <arr.length ; fast++) {
                if(arr[fast]!=arr[slow]){
                    arr[slow] = arr[fast];
                    slow++;
                }
            }
            return slow;
    }
}
