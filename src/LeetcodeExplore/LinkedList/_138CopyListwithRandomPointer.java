package LeetcodeExplore.LinkedList;

//https://leetcode.com/problems/copy-list-with-random-pointer/

public class _138CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        Node iter = head, next;
        while (iter != null) {
            next = iter.next;
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;
            iter = next;
        }

        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        iter = head;
        Node dummy = new Node(-1);
        Node copy, copyiter = dummy;

        while (iter != null) {
            next = iter.next.next;

            copy = iter.next;
            copyiter.next = copy;
            copyiter = copy;
            iter.next = next;
            iter = next;

        }

        return dummy.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
