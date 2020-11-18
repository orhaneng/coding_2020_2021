package LeetcodeExplore.RecursionI.ArrayAndString;
//https://leetcode.com/problems/find-pivot-index/

public class _724FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        int leftsum=0;
        for(int i : nums) sum+=i;

        for(int i=0;i<nums.length;i++){

            if(leftsum == sum -leftsum - nums[i]) return i;  //28-1 i=0, 27-1-7 i=1,
            leftsum += nums[i];
        }
        return -1;
    }
}
