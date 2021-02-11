package LeetcodeAmazon;

import java.util.*;

public class _103BinaryTreeZigzagLevelOrderTraversal {

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean flag = true;
            while (!queue.isEmpty()) {
                LinkedList<Integer> nest = new LinkedList<>();
                int size = queue.size();
                while (size > 0) {
                    size--;
                    TreeNode node = queue.poll();
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                    if (!flag) {
                        nest.add(0,node.val);
                    }else{
                        nest.add(0,node.val);
                    }
                }
                if (!flag) {
                    Collections.reverse(nest);
                }
                flag = !flag;
                res.add(nest);
            }
            return res;
        }
    }
}
