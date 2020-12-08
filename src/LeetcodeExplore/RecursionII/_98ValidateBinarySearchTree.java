package LeetcodeExplore.RecursionII;
//https://leetcode.com/problems/validate-binary-search-tree/

import LeetcodeExplore.BinaryTree.TreeNode;

public class _98ValidateBinarySearchTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        //root.right=new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        System.out.println(isValidBST(root));

    }
    public static boolean isValidBST(TreeNode root) {
        return help(root,null,null);


    }

    public static boolean help(TreeNode root,Integer lower, Integer upper) {
        if(root==null) return true;

        if(upper!=null && root.val >= upper || lower!=null && root.val <= lower) return false;
        return help(root.left,lower,root.val) && help(root.right,root.val,upper);

    }


}
