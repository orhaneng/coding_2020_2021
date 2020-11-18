package LeetcodeExplore.RecursionI.Arrays101;
//https://leetcode.com/problems/remove-element/
public class _27RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if(nums.length==0) return 0;

        int late =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[late] = nums[i];
                late++;
            }
        }
        return late;
    }
}
