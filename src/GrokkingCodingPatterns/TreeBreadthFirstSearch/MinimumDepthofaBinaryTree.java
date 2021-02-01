package GrokkingCodingPatterns.TreeBreadthFirstSearch;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/

/*

Problem Statement #
Find the minimum depth of a binary tree.
The minimum depth is the number of nodes along the shortest path from the root node to the nearest leaf node.


Time complexity #
The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree.
This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N)O(N) which is required for the queue.
Since we can have a maximum of N/2N/2 nodes at any level (this could happen only at the lowest level),
therefore we will need O(N) space to store them in the queue.

 */
import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofaBinaryTree {

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

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth  = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return depth;
    }
}
