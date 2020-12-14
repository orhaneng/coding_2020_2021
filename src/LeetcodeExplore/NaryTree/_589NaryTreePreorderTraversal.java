package LeetcodeExplore.NaryTree;

//https://leetcode.com/problems/n-ary-tree-preorder-traversal/

import java.util.ArrayList;
import java.util.List;

public class _589NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null)
            return res;
        helper(root,res);
        return res;
    }

    public void helper(Node node, List<Integer> list){
        if(node == null) return;
        list.add(node.val);
        for(Node item : node.children)
            helper(item,list);
    }


}
