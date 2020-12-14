package LeetcodeExplore.BinarySearchTree;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
/*
TIME O(N)
SPACE O(N)
 */
import LeetcodeExplore.BinaryTree.TreeNode;

public class _235LowestCommonAncestorofaBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(8);
        TreeNode res = lowestCommonAncestor(root,new TreeNode(2), new TreeNode(8));
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        int parentval = root.val;
        int pval = p.val;
        int qval = q.val;
        if(pval>parentval  && qval > parentval) return lowestCommonAncestor(root.right,p,q);
        else if(pval<parentval && qval < parentval) return lowestCommonAncestor(root.left,p,q);
        else return root;
    }
}
