package LeetcodeExplore.RecursionI.ArrayAndString;
//https://leetcode.com/problems/max-consecutive-ones/
public class _485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
                max = Math.max(max,count);
            }else{
                count=0;
            }
        }
        return max;
    }
}
