package LeetcodeExplore.RecursionI.Arrays101;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class _26RemoveDuplicatesfromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int late= 1;
        int fast =0;
        for(int i=1;i<nums.length;i++){//1,2
            if(nums[i]!=nums[i-1]){
                nums[late++]=nums[i];
            }
        }
        return late;
    }
    public static int removeDuplicatesBrute(int[] nums) {
        int first=1;
        int length= nums.length;
        int count=1;
        int max= -99999999;
        while(first<length){
            if(nums[first-1] ==nums[first] || nums[first-1] > nums[first]){
                int second= first+1;
                while(second<length){
                    if(nums[first-1]< nums[second] && nums[second]>max){
                        nums[first] = nums[second];
                        break;
                    }
                    second++;
                }
            }
            first++;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>=nums[i])
                break;
            count++;
        }
        return count;
    }
}
