package LeetcodeExplore.RecursionII;
//https://leetcode.com/problems/permutations/

import java.util.ArrayList;
import java.util.List;

/*
TIME:O(N!)
SPACE:O(N!)
 */
public class _46Permutations {
    public static void main(String[] args) {
        permute(new int[]{1, 2, 3}).stream().forEach(System.out::println);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 2) return res;
        helper(res, nums,  new ArrayList<Integer>());
        return res;
    }

    public static void helper(List<List<Integer>> res, int[] nums,  List<Integer> arr) {
        if (arr.size() >= nums.length) {
            res.add(new ArrayList<>(arr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(arr.contains(nums[i])) continue;
            arr.add(nums[i]);
            arr.stream().forEach(System.out::print);
            System.out.println();
            helper(res, nums,  arr);
            arr.remove(arr.size() - 1);
        }
    }
}
