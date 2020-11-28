package LeetcodeExplore.LinkedList;
//https://leetcode.com/problems/linked-list-cycle-ii/


public class _142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow =head,fast = head, start = head;


        while(fast!=null &&  fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                while(slow!=start){
                    slow= slow.next;
                    start = start.next;
                }
                return start;
            };

        }

        return null;
    }
}
