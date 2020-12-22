package GrokkingCodingPattern.CyclicSort;

/*
Problem Statement #
We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.

Example 1:

Input: [4, 0, 3, 1]
Output: 2
Example 2:

Input: [8, 3, 5, 2, 4, 6, 0, 1]
Output: 7


Time complexity #
The time complexity of the above algorithm is O(n)O(n). In the while loop,
although we are not incrementing the index i when swapping the numbers,
this will result in more than ‘n’ iterations of the loop, but in the worst-case scenario,
the while loop will swap a total of ‘n-1’ numbers and once a number is at its correct index,
we will move on to the next number by incrementing i. In the end, we iterate the input array
again to find the first number missing from its index, so overall, our algorithm will take O(n) + O(n-1)
 + O(n)O(n)+O(n−1)+O(n) which is asymptotically equivalent to O(n)O(n).

Space complexity #
The algorithm runs in constant space O(1)O(1).

Mark as Completed


 */
public class FindTheMissingNumber {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1}));
    }

    public static int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[nums[i]] != nums[i]) {
                swap(nums, i, nums[i]);
            } else
                i++;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) return j;
        }
        return -1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
