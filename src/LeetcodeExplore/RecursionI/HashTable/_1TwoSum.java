package LeetcodeExplore.RecursionI.HashTable;
//https://leetcode.com/problems/two-sum/

import java.util.HashMap;
import java.util.Map;

public class _1TwoSum {


    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                    return res;
                }
            }
        }
        return res;
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int remain = target-nums[i];
            if(map.containsKey(remain)){
                return new int[]{map.get(remain),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
