package GrokkingCodingPatterns.ModifiedBinarySearch;

public class OrderAgnosticBinarySearch {


    /*

    Problem Statement #
        Given a sorted array of numbers, find if a given number ‘key’ is present in the array.
        Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order.
        You should assume that the array can have duplicates.

        Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.

        Example 1:

        Input: [4, 6, 10], key = 10
        Output: 2
        Example 2:

        Input: [1, 2, 3, 4, 5, 6, 7], key = 5
        Output: 4
        Example 3:

        Input: [10, 6, 4], key = 10
        Output: 0
        Example 4:

        Input: [10, 6, 4], key = 4
        Output: 2



    Time complexity #
        Since, we are reducing the search range by half at every step, this means that the time complexity of our algorithm
        will be O(logN)O(logN) where ‘N’ is the total elements in the given array.

    Space complexity #
        The algorithm runs in constant space O(1)O(1).

     */
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,6,10},10));
    }

    public static int search(int[] arr, int key) {
        if (arr.length == 0) return -1;
        int n = arr.length - 1;
        boolean isAscending = (arr[0] - arr[n]) < 0;
        int start = 0;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid]==key) return mid;
            if(isAscending){
                if (arr[mid] > key) {
                    end = mid - 1;

                }else{
                    start = mid + 1;
                }
            }else{
                if (arr[mid] > key) {
                    start = mid + 1;

                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
