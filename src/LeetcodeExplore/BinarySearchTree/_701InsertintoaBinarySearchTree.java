package LeetcodeExplore.BinarySearchTree;
//https://leetcode.com/problems/insert-into-a-binary-search-tree/

import LeetcodeExplore.BinaryTree.TreeNode;
/*
time O(H)
SPACE O(H)
 */
public class _701InsertintoaBinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);

        if(root.val > val) root.left =  insertIntoBST(root.left, val);
        if(root.val < val) root.right = insertIntoBST(root.right, val);

        return root;
    }

}
