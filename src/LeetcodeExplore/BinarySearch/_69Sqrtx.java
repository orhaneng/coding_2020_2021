package LeetcodeExplore.BinarySearch;
//https://leetcode.com/problems/sqrtx/
/*
TIME O(LOGN)
SPACE O(1)
 */
public class _69Sqrtx {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        if(x<2) return x;

        int begin=0;
        int end = x/2;
        long num;
        while(begin<=end){
            int mid = begin+(end-begin)/2;
            num = (long)mid*mid;
            if(num>x) end = mid-1;
            else if(num<x) begin = mid+1;
            else return mid;
        }
        return end;
    }
}
