package LeetcodeExplore.RecursionI.Arrays101;
//https://leetcode.com/problems/sort-array-by-parity/
public class _905SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        for(int i=0,index =0;i<A.length;i++){
            if(A[i]%2==0){
                int temp = A[index];
                A[index++]=A[i];
                A[i]=temp;
            }
        }
        return A;
    }
}
