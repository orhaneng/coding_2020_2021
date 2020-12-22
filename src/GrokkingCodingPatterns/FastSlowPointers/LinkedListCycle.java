package GrokkingCodingPatterns.FastSlowPointers;


//https://leetcode.com/problems/linked-list-cycle/

public class LinkedListCycle {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = new Node(6);

        //System.out.println(hasCycle(root));

        root.next.next.next.next.next.next = root.next.next;

        System.out.println(findCycleLength(root));

        root.next.next.next.next.next.next = root.next.next.next;

        //System.out.println(hasCycle(root));
    }

    public static boolean hasCycle(Node node) {

        /*
            Time Complexity #
            As we have concluded above, once the slow pointer enters the cycle, the fast pointer will meet the slow pointer in the same loop.
            Therefore, the time complexity of our algorithm will be O(N) where ‘N’ is the total number of nodes in the LinkedList.
            Space Complexity #
            The algorithm runs in constant space O(1).
         */
        if (node == null) return false;

        Node slow = node;
        Node fast = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    /*
        Problem 1: Given the head of a LinkedList with a cycle, find the length of the cycle.
     */

    public static int findCycleLength(Node node) {
        if (node == null) return 0;
        Node slow = node;
        Node fast = node;
        int count = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                Node current = slow;
                do {
                    count++;
                    current = current.next;
                } while (slow != current);
                return count;
            }
        }
        return count;
    }
}
