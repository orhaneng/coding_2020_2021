package LeetcodeExplore.ArrayAndString;
//https://leetcode.com/problems/array-partition-i/

import java.util.Arrays;

public class _561ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        if(nums.length == 0) return 0;

        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i+=2){
            sum+= nums[i];
        }
        return sum;
    }
}
