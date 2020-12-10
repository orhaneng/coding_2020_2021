package LeetcodeExplore.BinarySearch;
//https://leetcode.com/problems/binary-search/

public class _704BinarySearch {
    public int search(int[] nums, int target) {
        return help(nums,0,nums.length-1,target);
    }

    public static int help(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + end / 2;
            if(nums[mid]==target) return mid;
            if(target<nums[mid]){
                help(nums,start,mid-1,target);
            }else{
                help(nums,mid+1,end,target);
            }
        }
        return -1;
    }

}
