package LeetcodeAmazon;
//https://leetcode.com/problems/subtree-of-another-tree/


public class _572SubtreeofAnotherTree {
    public static void main(String[] args) {
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(1);
        TreeNode t = new TreeNode(1);
        System.out.println(Solution.isSubtree(s, t));
    }

}

class Solution {

    /*
    Time complexity : O(m*n)O(m∗n). In worst case(skewed tree) traverse function takes O(m*n)O(m∗n) time.

Space complexity : O(n)O(n). The depth of the recursion tree can go upto nn. nn refers to the number of nodes in ss.
     */
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        return help(s, t);
    }

    public static boolean help(TreeNode s, TreeNode t) {//s:1 t:1
        return s != null && (equal(s, t) || help(s.left, t) || help(s.right, t));
    }

    public static boolean equal(TreeNode s, TreeNode t) {
        if (s == null && t == null)//f
            return true;
        if (s == null || t == null) //f
            return false;

        return s.val == t.val && equal(s.left, t.left) && equal(s.right, t.right);
    }
}

class TreeNode {
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