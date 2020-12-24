package GrokkingCodingPatterns.TreeDepthFirstSearch;

public class PathWithGivenSequence {
    /*
    Problem Statement #
        Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.

    Time complexity #
        The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree.
        This is due to the fact that we traverse each node once.

    Space complexity #
        The space complexity of the above algorithm will be O(N) in the worst case.
        This space will be used to store the recursion stack.
        The worst case will happen when the given tree is a linked list (i.e., every node has only one child).

     */
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(9);

        System.out.println(findPath(root, new int[]{1, 9, 9}));

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(0);
//        root.left.left = new TreeNode(1);
//        root.right = new TreeNode(1);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(5);
//
//        System.out.println(findPath(root, new int[]{1, 1, 6}));
    }

    public static boolean findPath(TreeNode root, int[] sequence) {
        return helper(root, sequence,0);
    }

    public static boolean helper(TreeNode root, int[] sequence, int count) {
        if (root == null) return false;
        if (sequence[count] == root.val)  count++;
        if (count  == sequence.length) return true;

        return helper(root.left, sequence, count) ||  helper(root.right, sequence, count);
    }
}
