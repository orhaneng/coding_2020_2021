package GrokkingCodingPatterns.InPlaceReversalOfALinkedList;

public class ReverseEveryKElementSublist {

    /*
    Problem Statement #
Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.

If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.

Time complexity #
The time complexity of our algorithm will be O(N)O(N) where ‘N’ is the total number of nodes in the LinkedList.

Space complexity #
We only used constant space, therefore, the space complexity of our algorithm is O(1)O(1).

     */

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

    public ListNode reverseEveryKElementSublist(ListNode head, int k) {

        if (k <= 1 && head == null) return head;

        ListNode current = head, previous = null;

        while (true) {

            ListNode lastNodeOfPartOne = previous;
            ListNode lastNodeOfSublist = current;
            ListNode next = null;

            for (int i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            if (lastNodeOfPartOne != null) {
                lastNodeOfPartOne.next = previous;
            } else {
                head = previous;
            }


            lastNodeOfSublist.next = current;

            if (current == null) {
                break;
            }
            previous = lastNodeOfSublist;

        }
        return head;
    }
}
