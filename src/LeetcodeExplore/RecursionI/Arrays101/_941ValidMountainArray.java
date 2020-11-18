package LeetcodeExplore.RecursionI.Arrays101;
//https://leetcode.com/problems/valid-mountain-array/

public class _941ValidMountainArray {
    public static void main(String[] args) {

    }

    public boolean validMountainArray2(int[] A) {
        if(A.length == 0) return false;
        boolean increase = false;
        boolean decrease = false;
        for(int i=1;i<A.length;i++){
            if(A[i]>A[i-1] & !decrease){
                increase = true;
            }
            else if(A[i]<A[i-1] & increase){
                decrease = true;
            }
            else if(decrease & (A[i]>A[i-1])) return false;
            else if(!increase & (A[i]<A[i-1])) return false;
            else if((A[i]==A[i-1])) return false;
        }
        if(increase & decrease) return true;
        else return false;
    }
}
