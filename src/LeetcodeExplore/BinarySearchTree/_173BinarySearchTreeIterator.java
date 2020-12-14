package LeetcodeExplore.BinarySearchTree;

import LeetcodeExplore.BinaryTree.TreeNode;

import java.util.Stack;

public class _173BinarySearchTreeIterator {

    public class BSTIterator {
        private Stack<TreeNode> stack = new Stack<>();
        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        public int next() {
            TreeNode node = stack.pop();
            pushAll(node.right);
            return node.val;
        }

        public void pushAll(TreeNode root){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
        }
        public boolean hasNext() {
            return !stack.isEmpty();
        }

    }
}
