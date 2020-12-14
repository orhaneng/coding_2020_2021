package LeetcodeExplore.BinarySearchTree;
//https://leetcode.com/problems/validate-binary-search-tree/

import LeetcodeExplore.BinaryTree.TreeNode;

public class _98ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static boolean helper(TreeNode root, int max, int min) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }
}
