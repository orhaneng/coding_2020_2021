package GrokkingCodingPatterns.ModifiedBinarySearch;

public class CeilingofaNumber {

    /*

    Problem Statement #
    Given an array of numbers sorted in an ascending order, find the ceiling of a given number ‘key’.
    The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.

    Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1.

    Example 1:

    Input: [4, 6, 10], key = 6
    Output: 1
    Explanation: The smallest number greater than or equal to '6' is '6' having index '1'.
    Example 2:

    Input: [1, 3, 8, 10, 15], key = 12
    Output: 4
    Explanation: The smallest number greater than or equal to '12' is '15' having index '4'.
    Example 3:

    Input: [4, 6, 10], key = 17
    Output: -1
    Explanation: There is no number greater than or equal to '17' in the given array.
    Example 4:

    Input: [4, 6, 10], key = -1
    Output: 0
    Explanation: The smallest number greater than or equal to '-1' is '4' having index '0'.



    Time complexity #
        Since we are reducing the search range by half at every step, this means that the time complexity of our algorithm will
        be O(logN)O(logN) where ‘N’ is the total elements in the given array.

    Space complexity #
        The algorithm runs in constant space O(1)O(1).


     */
    public static void main(String[] args) {
        int[] arr = {4, 6, 10};
        int[] arr1 = {1,3,8,10,15};
        int[] arr2 = {7,6,10};
        int[] arr3 = {4, 6, 10};

        System.out.println(searchCeilingOfANumber(arr, 6));
        System.out.println(searchCeilingOfANumber(arr1, 12));
        System.out.println(searchCeilingOfANumber(arr2, 17));
        System.out.println(searchCeilingOfANumber(arr3, -1));
    }

    public static int searchCeilingOfANumber(int[] arr, int key) {

        if (key > arr[arr.length-1]) return -1;

        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) return mid;

            if (arr[mid] > key) end = mid - 1;
            else start = mid + 1;
        }

        return start;
    }
}
