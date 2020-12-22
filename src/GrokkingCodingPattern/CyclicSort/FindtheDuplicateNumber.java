package GrokkingCodingPattern.CyclicSort;
//https://leetcode.com/problems/find-the-duplicate-number/

public class FindtheDuplicateNumber {
    /*
        Problem Statement #
        We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
        The array has only one duplicate but it can be repeated multiple times. Find that duplicate number
        without using any extra space. You are, however, allowed to modify the input array.

        Example 1:

        Input: [1, 4, 4, 3, 2]
        Output: 4
        Example 2:

        Input: [2, 1, 3, 3, 5, 4]
        Output: 3
        Example 3:

        Input: [2, 4, 1, 4, 4]
        Output: 4

        Time complexity #
        The time complexity of the above algorithm is O(n)O(n).

        Space complexity #
        The algorithm runs in constant space O(1)O(1) but modifies the input array.
     */

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 4, 4, 3, 2}));
        ;
    }

    public static int findDuplicate2(int[] nums) {


        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int current = nums[0];
        while (slow != current) {
            slow = nums[slow];
            current = nums[current];
        }
        return current;
    }
}
