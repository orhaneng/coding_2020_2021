package LeetcodeExplore.LinkedList;
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class _19RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        while(fast != null){
            fast = fast.next;
            if(n--<0){
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
    /*
    O(N) TIME
    O(1) SPACE
     */
}
