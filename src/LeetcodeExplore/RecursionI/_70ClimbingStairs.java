package LeetcodeExplore.RecursionI;
//https://leetcode.com/problems/climbing-stairs/
/*

TIME O(N)
SPACE O(N)
 */
public class _70ClimbingStairs {
    public int climbStairs(int n) {
        int[] mem = new int[n];
        return help(0,n,mem );
    }

    public int help(int i,int n,int[] mem ){
        if(i>n) return 0;
        if(i==n) return 1;
        if(mem[i]>0) return mem[i];
        int sum = help(i+1,n,mem)+help(i+2,n,mem);
        mem[i] =sum;
        return sum;
    }
}
