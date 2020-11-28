package LeetcodeExplore.Arrays101;
//https://leetcode.com/problems/squares-of-a-sorted-array/

import java.util.Arrays;

public class _977SquaresofaSortedArray {
    public int[] sortedSquares2(int[] A) {
        return Arrays.stream(A).map(i->i*i).sorted().toArray();
    }

    public int[] sortedSquares(int[] A) {
        int right= A.length-1;
        int left =0;
        int indes = A.length-1;
        int[] res = new int[A.length];
        while(left<=right){
            if(Math.abs(A[left])>Math.abs(A[right])){
                res[indes--]= A[left]*A[left];
                left++;
            }else{
                res[indes--]= A[right]*A[right];
                right--;
            }
        }
        return res;
    }
}
