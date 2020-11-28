package LeetcodeExplore.LinkedList;
//https://leetcode.com/problems/odd-even-linked-list/

public class _328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;

        ListNode odd=head, even= head.next, evenHead= even;

        while(odd.next!=null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next=odd.next;
            even = even.next;
        }
        odd.next=evenHead;
        return head;
    }

}
