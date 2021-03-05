package LeetcodeAmazon;
//https://leetcode.com/problems/search-a-2d-matrix-ii/

public class _240Searcha2DMatrixII {


    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};

        System.out.println(searchMatrix(matrix, 5));

    }

    // TIME O(NLOGN)
    //SPACE O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }

    /*
    Time complexity : \mathcal{O}(n+m)O(n+m)
    Space o(1)
        public static boolean searchMatrix(int[][] matrix, int target) {
        int row= matrix.length-1;
        int col =0;

        while(row>=0 && col<matrix[0].length){
            if(matrix[row][col]>target)
                row--;
            else if(matrix[row][col]<target)
                col++;
            else return true;
        }
        return false;
    }
     */

}
