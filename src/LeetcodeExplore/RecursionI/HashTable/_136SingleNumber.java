package LeetcodeExplore.RecursionI.HashTable;

import java.util.*;

public class _136SingleNumber {
    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
                continue;
            }
            set.add(nums[i]);
        }

        //int i = (int)set.toArray()[0];
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        List<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Collections.sort(set);
        //int[] nums = {2,1,4,5,2,4,1};
        //System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] num){
        int result = 0;
        for (int i = 0; i<num.length; i++)
        {
            result ^=num[i];
        }
        return result;
    }


}
