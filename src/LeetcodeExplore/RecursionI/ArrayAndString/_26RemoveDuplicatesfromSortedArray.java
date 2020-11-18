package LeetcodeExplore.RecursionI.ArrayAndString;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class _26RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
    }
    public static int removeDuplicates(int[] nums) {
        int late= 1;
        for(int i=1;i<nums.length;i++){//1,2
            if(nums[i]!=nums[i-1]){
                nums[late++]=nums[i];
            }
        }
        return late;
    }
}
