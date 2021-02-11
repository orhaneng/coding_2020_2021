package GrokkingRecursionforCodingInterviews;

import LeetcodeExplore.BinaryTree.TreeNode;

public class InsertValuesinaBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        insert(root,4);
        insert(root,8);
        insert(root,2);
        insert(root,5);

        root=root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode insert(TreeNode root, int data) {
        if (root == null)
            return new TreeNode(data);

        if (data < root.val) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

}
