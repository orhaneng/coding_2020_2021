package GrokkingCodingPatterns.TreeDepthFirstSearch;

//https://leetcode.com/problems/path-sum/


/*

Problem Statement #
Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that the
sum of all the node values of that path equals ‘S’.


Time complexity #
The time complexity of the above algorithm is O(N)O(N),
where ‘N’ is the total number of nodes in the tree. This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N)O(N) in the worst case.
This space will be used to store the recursion stack. The worst case will happen
when the given tree is a linked list (i.e., every node has only one child).
 */
public class BinaryTreePathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;

        if(root.left == null && root.right == null && sum - root.val== 0) return true;

        return hasPathSum(root.left, sum - root.val)||hasPathSum(root.right, sum-root.val);
    }

}
