package LeetcodeExplore.QueueStack;
//https://leetcode.com/problems/target-sum/

public class _494TargetSum {

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1},3));
    }
    public static int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0) return 0;
        return help(nums,S,0,0);
    }

    public static int help(int[] nums, int S, int sum, int index){
        if(index == nums.length){
            return S == sum? 1:0;
        }
        return help(nums, S, sum + nums[index], index+1)+help(nums, S, sum - nums[index], index+1);
    }
}
