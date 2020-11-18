package LeetcodeExplore.BinaryTree;
//https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class _102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int levelcount = queue.size();
            for (int i = 0; i < levelcount; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!= null){
                    queue.add(node.left);
                }
                if(node.right!= null){
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
