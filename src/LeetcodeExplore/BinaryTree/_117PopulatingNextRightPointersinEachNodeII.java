package LeetcodeExplore.BinaryTree;
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

import java.util.LinkedList;
import java.util.Queue;


public class _117PopulatingNextRightPointersinEachNodeII {

    public Node connect(Node root) {
        if(root == null ) return root;

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);//1
        while(queue.size()>0){//
            Node prev = null;
            int size = queue.size();
            for (int i = 0; i <size ; i++) { //1
                Node node = queue.poll();//1
                if(prev!=null){//F
                    prev.next = node;
                }
                if(node.left!= null ) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                prev =node;//1
                if(i == size-1) node.next=null;
            }
        }
        return root;
    }
}

/*

queue  2,3


 */