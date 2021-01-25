package LeetcodeAmazon;
//https://leetcode.com/problems/merge-two-sorted-lists/

public class _21MergeTwoSortedLists {

    /*
    TIME O(M+N)
    SPACE O(1)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode newNode = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newNode.next = l1;
                l1 = l1.next;
            } else {
                newNode.next = l2;
                l2 = l2.next;
            }
            newNode = newNode.next;
        }

        newNode.next = l1 != null ? l1 : l2;

        return head.next;
    }

    public class ListNode {
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

}
