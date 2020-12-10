package LeetcodeExplore.BinarySearch;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class _153FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums.length==0) return 0;
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        return hi;
    }
}
