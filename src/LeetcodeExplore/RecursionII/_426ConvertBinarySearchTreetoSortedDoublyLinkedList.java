package LeetcodeExplore.RecursionII;
//https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

import LeetcodeExplore.LinkedList.ListNode;

public class _426ConvertBinarySearchTreetoSortedDoublyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(4);
        head.left= new Node(2);
        head.left.left= new Node(1);
        head.left.right= new Node(3);
        head.right = new Node(5);
        treeToDoublyList(head);

    }
    static Node prev;
    public static Node treeToDoublyList(Node root) {
        if(root==null) return root;

        Node dummy = new Node(0);
        prev = dummy;
        helper(root);
        prev.right=dummy.right;
        dummy.right.left=prev;
        return dummy.right;

    }

    public static void helper(Node cur){
        if(cur==null) return;
        helper(cur.left);
        prev.right = cur;
        cur.left=prev;
        prev=cur;
        helper(cur.right);
    }



    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
