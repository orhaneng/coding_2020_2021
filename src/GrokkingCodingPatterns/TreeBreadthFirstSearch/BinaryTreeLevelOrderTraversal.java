package GrokkingCodingPatterns.TreeBreadthFirstSearch;


import java.util.*;

//https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/

public class BinaryTreeLevelOrderTraversal {

    /*

    Problem Statement #
        Given a binary tree, populate an array to represent its level-by-level traversal.
        You should populate the values of all nodes of each level from left to right in separate sub-arrays.


    Time complexity #
The time complexity of the above algorithm is O(N)O(N), where ‘N’ is the total number of
nodes in the tree. This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N)O(N) as we need to return a list
containing the level order traversal. We will also need O(N)O(N) space for the queue.
Since we can have a maximum of N/2N/2 nodes at any level (this could happen only at the lowest level),
therefore we will need O(N)O(N) space to store them in the queue.
     */
    public class TreeNode {
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

    }
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sublist = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode child = queue.poll();
                sublist.add(child.val);
                if(child.left!=null) queue.add(child.left);
                if(child.right!=null) queue.add(child.right);
            }
            list.add(sublist);
        }
        return list;
    }
}
