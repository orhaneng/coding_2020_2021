package LeetcodeExplore.RecursionI;

//https://leetcode.com/problems/search-in-a-binary-search-tree/
/*
Time complexity : O(logN) in the average case, and O(N) in the worst case.
Space complexity: O(H) to keep the recursion stack, i.e. O(logN) in the average case, and O(N) in the worst case.
 */
import LeetcodeExplore.BinaryTree.TreeNode;

public class _700SearchinaBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        if(root.val==val) return root;
        return val<root.val?searchBST(root.left,val): searchBST(root.right,val);
    }
}
