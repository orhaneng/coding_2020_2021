package LeetcodeExplore.NaryTree;
//https://leetcode.com/problems/n-ary-tree-level-order-traversal/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _429NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;

        Stack<Node> stack = new Stack();

        stack.push(root);
        res.add(new ArrayList(Arrays.asList(new int[]{root.val})));

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            List<Integer> arr = new ArrayList();
            if (node.children != null)
                for (Node child : node.children) {
                    stack.push(child);
                    arr.add(child.val);
                }
            res.add(arr);
        }

        return res;
    }
}
