package GrokkingCodingPatterns.TreeBreadthFirstSearch;

//https://leetcode.com/problems/average-of-levels-in-binary-tree/

/*
Problem Statement #
Given a binary tree, populate an array to represent the averages of all of its levels.

Time complexity #
The time complexity of the above algorithm is O(N)O(N), where ‘N’ is the total number of nodes in the tree.
This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N)O(N) which is required for the queue.
Since we can have a maximum of N/2N/2 nodes at any level (this could happen only at the lowest level),
therefore we will need O(N)O(N) space to store them in the queue.


 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAveragesinaBinaryTree {

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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();

        if(root==null) return list;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Double sum = 0.0;
            for (int i = 0; i <size; i++) {
                TreeNode node = queue.poll();
                sum +=node.val;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            list.add(sum/size);
        }
        return list;
    }
}
