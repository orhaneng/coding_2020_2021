package HashTable;

//https://leetcode.com/problems/contains-duplicate/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _217ContainsDuplicate   {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])){
                return true;
            }
        }


        return false;

        //return Arrays.stream(nums).distinct().count() != nums.length;

    }
}
