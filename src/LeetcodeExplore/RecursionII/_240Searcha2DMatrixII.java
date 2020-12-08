package LeetcodeExplore.RecursionII;
//https://leetcode.com/problems/search-a-2d-matrix-ii/

//TIME O(M+N)
//SPACE O(1)


public class _240Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = 0;
        int row = matrix.length-1;;

        while(col<= matrix[0].length-1 && row>=0){
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col] > target) row--;
            else if(matrix[row][col] < target) col++;
        }

        return false;
    }
}
