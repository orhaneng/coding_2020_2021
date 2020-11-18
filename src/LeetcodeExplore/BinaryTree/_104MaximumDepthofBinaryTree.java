package LeetcodeExplore.BinaryTree;
//https://leetcode.com/problems/maximum-depth-of-binary-tree/

public class _104MaximumDepthofBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if(root== null) return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
