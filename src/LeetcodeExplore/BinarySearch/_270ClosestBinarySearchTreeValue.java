package LeetcodeExplore.BinarySearch;

//https://leetcode.com/problems/closest-binary-search-tree-value/


/*
TIME O(N)
SPACE O(LOGN)
 */
import LeetcodeExplore.BinaryTree.TreeNode;

public class _270ClosestBinarySearchTreeValue {

    Integer closest= Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        closest = root.val;
        if(root.left==null && root.right==null) return root.val;
        help(root,target);
        return closest;
    }

    public void help(TreeNode node, double target){
        if(node==null) return ;

        if(Math.abs(node.val-target) < Math.abs(closest- target))
            closest = node.val;

        help(node.left,target);
        help(node.right,target);
    }


}
