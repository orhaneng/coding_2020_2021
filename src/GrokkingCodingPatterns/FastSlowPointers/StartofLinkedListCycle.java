package GrokkingCodingPatterns.FastSlowPointers;

//https://leetcode.com/problems/linked-list-cycle-ii/submissions/

/*
Problem Statement #
Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.

TIME O(N)
SPACE O(1)
 */
public class StartofLinkedListCycle {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = new Node(6);
        root.next.next.next.next.next.next = root.next.next.next;
        System.out.println(findCycleSart(root).val);

    }

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node findCycleSart(Node root) {

        //https://leetcode.com/problems/linked-list-cycle-ii/discuss/44774/Java-O(1)-space-solution-with-detailed-explanation.
        Node slow = root;
        Node fast = root;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (slow != null && root != null && slow != root) {
                    slow = slow.next;
                    root = root.next;
                    if (slow == root)
                        return slow;
                }
            }
        }
        return null;
    }
}
