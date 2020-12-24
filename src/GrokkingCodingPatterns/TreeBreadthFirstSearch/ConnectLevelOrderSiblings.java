package GrokkingCodingPatterns.TreeBreadthFirstSearch;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevelOrderSiblings {

    /*
        Time complexity #
        The time complexity of the above algorithm is O(N)O(N), where ‘N’ is the total number of nodes in the tree.
        This is due to the fact that we traverse each node once.

        Space complexity #
        The space complexity of the above algorithm will be O(N)O(N), which is required for the queue.
        Since we can have a maximum of N/2N/2 nodes at any level (this could happen only at the lowest level),
        therefore we will need O(N)O(N) space to store them in the queue.
     */
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;

        Node no = root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(no);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size ; i++) {
                Node node = queue.poll();
                if(prev != null)
                    prev.next = node;
                prev = node;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
        }
        return root;
    }
}
