package GrokkingCodingPatterns.TreeDepthFirstSearch;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SumofPathNumbers {

    /*
    Problem Statement #
        Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number.
        Find the total sum of all the numbers represented by all paths.

        Time complexity #
            The time complexity of the above algorithm is O(N)O(N), where ‘N’ is the total number of nodes in the tree.
            This is due to the fact that we traverse each node once.

        Space complexity #
            The space complexity of the above algorithm will be O(N)O(N) in the worst case.
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 0);
    }
    public static int helper(TreeNode node, int num) {
        if (node == null) return 0;

        num = num * 10 + node.val;

        if (node.left == null && node.right == null) {
            return num;
        }
        return helper(node.left, num) +
                helper(node.right, num);
    }

}
