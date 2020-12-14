package LeetcodeExplore.BinarySearchTree;
//https://leetcode.com/problems/delete-node-in-a-bst/

import LeetcodeExplore.BinaryTree.TreeNode;

public class _450DeleteNodeinaBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        deleteNode(root,3);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }

        if(root.val > key) {
            root.left = deleteNode(root.left,key);
        }
        else if(root.val < key) {
            root.right = deleteNode(root.right,key);
        }
        else{
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            TreeNode p = findSucc(root.right);
            root.val = p.val;
            root.right = deleteNode(root.right,key);
            return root;
        }
        return root;
    }

    public static TreeNode findSucc(TreeNode node){
        while(node!=null && node.left!=null){
            node = node.left;
        }
        return node;
    }
}
