package LeetcodeExplore.BinaryTree;

//https://leetcode.com/problems/binary-tree-preorder-traversal/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        help(root,res);
        return res;
    }

    public void help(TreeNode node, List<Integer> list){
        if(node == null) return;
        list.add(node.val);
        help(node.left,list);
        help(node.right,list);
    }
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node!=null){
                res.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }

        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.add(root);
                root= root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;

        }
        return res;
    }

}
