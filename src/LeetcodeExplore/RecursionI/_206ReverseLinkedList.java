package LeetcodeExplore.RecursionI;
//https://leetcode.com/problems/reverse-linked-list/

/*
TIME O(N)
SPACE O(N)
 */
public class _206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next =null;
        return p;

    }



     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
