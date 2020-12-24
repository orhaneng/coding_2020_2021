package GrokkingCodingPatterns.TreeBreadthFirstSearch;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/discuss/?currentPage=1&orderBy=most_votes&query=

import java.util.*;

public class ZigzagTraversal {

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        boolean rightleft = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sublist = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode child = queue.poll();
                if(rightleft){
                    sublist.add(0, child.val);
                }else{
                    sublist.add( child.val);
                }
                if(child.left!=null) queue.add(child.left);
                if(child.right!=null) queue.add(child.right);
            }

            rightleft = !rightleft;

            list.add(sublist);
        }
        return list;
    }
}
