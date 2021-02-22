package LeetcodeAmazon;
//https://leetcode.com/problems/maximal-square/
//Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

/*
Time complexity : O(mn)O(mn). Single pass.

Space complexity : O(mn)O(mn). Another matrix of same size is used for dp.

 */
public class _221MaximalSquare {
    class Solution {
        public int maximalSquare(char[][] matrix) {

            int r = matrix.length;
            int c = matrix[0].length;
            int[][] res = new int[r+1][c+1];
            int max=0;
            for(int i=1;i<=r;i++){
                for(int j=1;j<=c;j++){
                    if(matrix[i-1][j-1]!='0')
                        res[i][j]= Math.min(Math.min(res[i][j-1], res[i-1][j]),res[i-1][j-1])               +1;
                    max = Math.max(max, res[i][j]);
                }
            }
            return max*max;
        }
    }
}
