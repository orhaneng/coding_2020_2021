package LeetcodeExplore.BinarySearchTree;
//https://leetcode.com/problems/inorder-successor-in-bst/
/*
TIME O(H)
SPACE O(1)
 */
import LeetcodeExplore.BinaryTree.TreeNode;


public class _285InorderSuccessorinBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        inorderSuccessor(root,new TreeNode(2));
    }
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null) return null;

        TreeNode suc =null;
        while (root!=null){
            if(p.val<root.val){
                suc = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return suc;

    }
}
