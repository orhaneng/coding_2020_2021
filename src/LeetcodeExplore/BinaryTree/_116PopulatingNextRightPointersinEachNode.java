package LeetcodeExplore.BinaryTree;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

public class _116PopulatingNextRightPointersinEachNode {
    public Node connect(Node root) {
        if(root == null) return root;
        Node start = root;

        while (start!= null){
            Node cur = start;
            while(cur!=null){
                if(cur.left!= null){
                    cur.left.next = cur.right;
                }
                if(cur.right!= null && cur.next!= null){
                    cur.right.next=cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
        return root;
    }
}
