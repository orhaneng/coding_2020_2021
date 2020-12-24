package GrokkingCodingPatterns.InPlaceReversalOfALinkedList;

//https://leetcode.com/problems/reverse-linked-list-ii/

import java.util.List;

public class ReverseaSublist {

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

    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == n) {
            return head;
        }

        ListNode current = head, previous = null;
        for (int i = 0; current != null && i < m - 1; i++) {
            previous = current;
            current = current.next;
        }

        ListNode lastNodeOfPartOne = previous;
        ListNode lastNodeOfSublist = current;
        ListNode next = null;

        for (int i = 0; current != null && i < n - m + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if(lastNodeOfPartOne !=null){
            lastNodeOfPartOne.next = previous;
        }else{
            head =previous;
        }

        lastNodeOfSublist.next = current;

        return head;
    }
}
