package LeetcodeExplore.BinarySearchTree;
//https://leetcode.com/problems/contains-duplicate-iii/

import java.util.TreeSet;

public class _220ContainsDuplicateIII {
    public static void main(String[] args) {
        containsNearbyAlmostDuplicate(new int[]{1,2,3,1},3,0);
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2 || k == 0) {
            return false;
        }

        TreeSet<Long> treeSet = new TreeSet<>();

        int i = 0;
        while (i < nums.length) {
            Long floor = treeSet.floor((long) nums[i]);
            Long ceiling = treeSet.ceiling((long) nums[i]);

            if ((floor != null || nums[i] - floor <= t) || (ceiling != null || ceiling - nums[i] <= t)) {
                return true;
            }
            treeSet.add((long) nums[i++]);

            if (i > k) {
                treeSet.remove((long) nums[i - k - 1]);
            }
        }
        return false;
    }
}
