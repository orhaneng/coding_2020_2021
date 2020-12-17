package LeetcodeExplore.BinarySearch;
//https://leetcode.com/problems/valid-perfect-square/

public class _367ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long begin = 2, end = num / 2;
        while (begin <= end) {
            long mid = begin + (end - begin) / 2;
            if (mid * mid == num) return true;
            if (mid * mid > num) end = mid - 1;
            else begin = mid + 1;
        }
        return false;
    }
}
