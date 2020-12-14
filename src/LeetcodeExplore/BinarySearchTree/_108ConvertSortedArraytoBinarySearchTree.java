package LeetcodeExplore.BinarySearchTree;
//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

import LeetcodeExplore.BinaryTree.TreeNode;

public class _108ConvertSortedArraytoBinarySearchTree {
    int nums[];
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0,nums.length-1);
    }

    public TreeNode helper(int left, int right){
        if(left>right) return null;

        int p = (left+right)/2;

        TreeNode root = new TreeNode(nums[p]);

        root.left = helper(left,p-1);
        root.right = helper(p+1,right);
        return root;
    }
}
