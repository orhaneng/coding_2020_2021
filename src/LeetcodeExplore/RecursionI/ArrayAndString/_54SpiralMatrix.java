package LeetcodeExplore.RecursionI.ArrayAndString;
//https://leetcode.com/problems/spiral-matrix/

import java.util.ArrayList;
import java.util.List;

public class _54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int rowbegin=0;
        int rowend = matrix.length-1;
        int colbegin=0;
        int colend = matrix[0].length-1;
        boolean route=true;
        while(rowbegin<=rowend && colbegin <= colend){
            for(int i=colbegin;i<=colend;i++){
                res.add(matrix[colbegin][i]);
            }
            rowbegin++;
            for(int i=rowbegin;i<=rowend;i++){
                res.add(matrix[i][colend]);
            }
            colend--;

            if(rowbegin<=rowend){
                for(int i=colend;i>=colbegin;i--){
                    res.add(matrix[rowend][i]);
                }
            }
            rowend--;
            if(colbegin<=colend){
                for(int i=rowend;i>=rowbegin;i--){
                    res.add(matrix[i][colbegin]);
                }
            }
            colbegin++;
        }
        return res;
    }
}
