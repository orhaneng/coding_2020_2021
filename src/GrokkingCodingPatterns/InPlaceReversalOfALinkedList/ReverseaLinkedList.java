package GrokkingCodingPatterns.InPlaceReversalOfALinkedList;

//https://leetcode.com/problems/reverse-linked-list/


/*

Time complexity #
The time complexity of our algorithm will be O(N)O(N) where ‘N’ is the total number of nodes in the LinkedList.

Space complexity #
We only used constant space, therefore, the space complexity of our algorithm is O(1)O(1).

Mark as Completed

 */
public class ReverseaLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }
}
