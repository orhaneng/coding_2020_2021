package LeetcodeExplore.ArrayAndString;
//https://leetcode.com/problems/minimum-size-subarray-sum/

public class _209MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){ //0
            int sum=0;
            int count=0;
            for(int j=i;j<nums.length;j++){ //0,1,2,3,4
                sum += nums[j];//1,3,6,10,15
                count++; //1,2,3,4,5
                if(sum >= s){//F,F,F,F,T
                    min = Math.min(count,min);
                }else if(sum>s){
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE?0:min;//3
    }
}
