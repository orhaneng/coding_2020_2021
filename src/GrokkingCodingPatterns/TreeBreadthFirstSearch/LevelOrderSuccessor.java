package GrokkingCodingPatterns.TreeBreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

    /*
    Time complexity #
        The time complexity of the above algorithm is O(N), where ‘N’ is the total number of nodes in the tree.
        This is due to the fact that we traverse each node once.

    Space complexity #
        The space complexity of the above algorithm will be O(N) which is required for the queue.
        Since we can have a maximum of N/2N/2 nodes at any level (this could happen only at the lowest level),
        therefore we will need O(N) space to store them in the queue.
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
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(findSuccessor(root, 3).val);
    }

    public static TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        boolean succ = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (succ) return node;
                if (node.val == key) succ = true;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return null;
    }
}
