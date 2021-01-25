package LeetcodeAmazon;
//https://leetcode.com/problems/two-sum/

import java.util.HashMap;

public class _1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> set = new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++)
            set.put(nums[i],i);

        for(int i=0;i<nums.length;i++){
            int remain = target - nums[i];
            if(set.containsKey(remain) ){
                int id1 = set.get(target - nums[i]);
                if(id1!=i)
                    return new int[] {id1,i};
            }
        }
        return res;
    }
}
