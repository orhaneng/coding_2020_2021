package LeetcodeExplore.BinaryTree;
//https://leetcode.com/problems/binary-tree-postorder-traversal/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _145BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        postorderTraversal2(root).stream().forEach(System.out::println);

    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        help(root,res);
        return res;
    }
    public static void help(TreeNode node, List<Integer> list){
        if(node == null) return;
        help(node.left,list);
        help(node.right,list);
        list.add(node.val);
    }

    public static List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ans;
    }
}
