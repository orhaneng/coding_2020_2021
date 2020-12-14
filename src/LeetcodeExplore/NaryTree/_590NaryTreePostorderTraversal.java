package LeetcodeExplore.NaryTree;

import java.util.*;
/*
time o(n)
space o(n)
 */
public class _590NaryTreePostorderTraversal {
    /*    public List<Integer> postorder(Node root) {
            List<Integer> res =new ArrayList();
            if(root==null) return res;
            helper(root,res);
            return res;

        }

        public void helper(Node node, List<Integer> list){
            if(node == null) return;
            for(Node item : node.children)
                helper(item,list);
            list.add(node.val);
        }*/
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;

        Queue<Node> queue = new LinkedList();

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> arr = new ArrayList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node nod = queue.poll();
                arr.add(nod.val);
                queue.addAll(nod.children);
            }
            if (arr.size() > 0)
                res.add(arr);
        }

        return res;
    }

}
