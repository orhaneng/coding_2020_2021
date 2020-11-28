package LeetcodeExplore.LinkedList;

//https://leetcode.com/problems/reverse-linked-list/

public class _206ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next= new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = reverseList(head);

        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        // is there something to reverse?
        if (head != null && head.next != null)
        {
            ListNode pivot = head;
            ListNode frontier = null;
            while (pivot != null && pivot.next != null)
            {
                frontier = pivot.next;
                pivot.next = pivot.next.next;
                frontier.next = head;
                head = frontier;
            }
        }

        return head;
    }
}
