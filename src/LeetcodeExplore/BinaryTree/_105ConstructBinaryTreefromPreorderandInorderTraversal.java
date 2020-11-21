package LeetcodeExplore.BinaryTree;
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class _105ConstructBinaryTreefromPreorderandInorderTraversal {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return help(preorder, 0,preorder.length-1,inorder, 0,inorder.length-1,map);
    }

    public static TreeNode help(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend,
                         HashMap<Integer,Integer> map){
        if(prestart>preend || instart > inend) return null;

        TreeNode root = new TreeNode(preorder[prestart]);
        int inroot = map.get(root.val);
        int numleft = inroot- instart;

        root.left = help(preorder, prestart+1, prestart+numleft, inorder, instart, inroot-1, map);
        root.right = help(preorder, prestart+numleft+1, preend, inorder, inroot+1, inend, map);

        List<Integer> list = new LinkedList<>();
        List<Integer> arraylist = new ArrayList<>();

            return root;
    }
}
