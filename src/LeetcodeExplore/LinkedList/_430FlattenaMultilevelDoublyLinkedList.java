package LeetcodeExplore.LinkedList;

//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

public class _430FlattenaMultilevelDoublyLinkedList {
    private Node flattentail(Node head) {
        if (head == null) return head; // CASE 1
        if (head.child == null) {
            if (head.next == null) return head; // CASE 2
            return flattentail(head.next); // CASE 3
        }
        else {
            Node child = head.child;
            head.child = null;
            Node next = head.next;
            Node childtail = flattentail(child);
            head.next = child;
            child.prev = head;
            if (next != null) { // CASE 5
                childtail.next = next;
                next.prev = childtail;
                return flattentail(next);
            }
            return childtail; // CASE 4
        }
    }
    class Node {
        public Node(int val){
            this.val=val;
        }
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
