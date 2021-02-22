package GrokkingCodingPatterns.ModifiedBinarySearch;


import java.lang.reflect.Array;
import java.util.Arrays;

public class NumberRange {

    /*
    Problem Statement #
        Given an array of numbers sorted in ascending order, find the range of a given number ‘key’. The range of the ‘key’ will be the first and last position of the ‘key’ in the array.

        Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].

    Example 1:

        Input: [4, 6, 6, 6, 9], key = 6
        Output: [1, 3]
        Example 2:

        Input: [1, 3, 8, 10, 15], key = 10
        Output: [3, 3]
        Example 3:

        Input: [1, 3, 8, 10, 15], key = 12
        Output: [-1, -1]

        Time complexity #
        Since, we are reducing the search range by half at every step, this means that the time complexity of our algorithm will be O(logN)O(logN) where ‘N’ is the total elements in the given array.

        Space complexity #
        The algorithm runs in constant space O(1)O(1).

     */

    public static void main(String[] args) {
        Arrays.stream(findRange(new int[]{4, 6, 6, 6, 9},6)).forEach(System.out::println);
        Arrays.stream(findRange(new int[]{1, 3, 8, 10, 15},10)).forEach(System.out::println);
        Arrays.stream(findRange(new int[]{1, 3, 8, 10, 15},12)).forEach(System.out::println);


    }

    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[]{-1,-1};
        result[0] = search(arr, key, false);
        if(result[0]!=-1)
            result[1] = search(arr, key, true);
        return result;
    }
    public static int search(int[] arr, int key, boolean findMaxIndex) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < key) {
                left = mid+1;
            }else if(arr[mid] > key){
                right=mid-1;
            }else{
                index = mid;
                if(findMaxIndex){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return index;
    }
}
