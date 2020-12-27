package GrokkingCodingPatterns.ModifiedBinarySearch;

public class FloorofaNumber {

    /*

Similar Problems #
Problem 1 #
Given an array of numbers sorted in ascending order, find the floor of a given number ‘key’. The floor of the ‘key’ will be the biggest element in the given array smaller than or equal to the ‘key’

Write a function to return the index of the floor of the ‘key’. If there isn’t a floor, return -1.

Example 1:

Input: [4, 6, 10], key = 6
Output: 1
Explanation: The biggest number smaller than or equal to '6' is '6' having index '1'.
Example 2:

Input: [1, 3, 8, 10, 15], key = 12
Output: 3
Explanation: The biggest number smaller than or equal to '12' is '10' having index '3'.
Example 3:

Input: [4, 6, 10], key = 17
Output: 2
Explanation: The biggest number smaller than or equal to '17' is '10' having index '2'.
Example 4:

Input: [4, 6, 10], key = -1
Output: -1
Explanation: There is no number smaller than or equal to '-1' in the given array.
Cod




    Time complexity #
        Since we are reducing the search range by half at every step, this means that the time complexity of our algorithm will
        be O(logN)O(logN) where ‘N’ is the total elements in the given array.

    Space complexity #
        The algorithm runs in constant space O(1)O(1).


     */
    public static void main(String[] args) {
        int[] arr = {4, 6, 10};
        int[] arr1 = {1,3,8,10,15};
        int[] arr2 = {4,6,10};
        int[] arr3 = {4, 6, 10};

        System.out.println(searchCeilingOfANumber(arr, 6));
        System.out.println(searchCeilingOfANumber(arr1, 12));
        System.out.println(searchCeilingOfANumber(arr2, 17));
        System.out.println(searchCeilingOfANumber(arr3, -1));
    }

    public static int searchCeilingOfANumber(int[] arr, int key) {

        if (key < arr[0]) return -1;

        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) return mid;

            if (arr[mid] > key) end = mid - 1;
            else start = mid + 1;
        }

        return end;
    }
}
