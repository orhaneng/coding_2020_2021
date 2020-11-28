package LeetcodeExplore.LinkedList;
//https://leetcode.com/problems/rotate-list/

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class _61RotateList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        rotateRight(head, 2);

    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;

        ListNode copyHead = head;

        int len = 1;
        while (copyHead.next != null) {
            copyHead = copyHead.next;
            len++;
        }

        copyHead.next = head;

        for (int i = len - k % len; i > 1; i--)
            head = head.next;

        copyHead = head.next;
        head.next = null;

        return copyHead;

    }
}
