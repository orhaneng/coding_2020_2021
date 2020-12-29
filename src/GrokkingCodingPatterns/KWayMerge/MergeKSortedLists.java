package GrokkingCodingPatterns.KWayMerge;

import java.util.PriorityQueue;

/*
Problem Statement #
Given an array of ‘K’ sorted LinkedLists, merge them into one sorted list.

Example 1:

Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4]
Output: [1, 2, 3, 3, 4, 6, 6, 7, 8]
Example 2:

Input: L1=[5, 8, 9], L2=[1, 7]
Output: [1, 5, 7, 8, 9]


Time complexity #
Since we’ll be going through all the elements of all arrays and will be removing/adding one element to
the heap in each step, the time complexity of the above algorithm will be O(N*logK),O(N∗logK), where ‘N’ is the total number
of elements in all the ‘K’ input arrays.

Space complexity #
The space complexity will be O(K)O(K) because, at any time, our min-heap will be storing one number from all the ‘K’ input arrays.



 */
public class MergeKSortedLists {


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

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node:lists){
            queue.add(node);
        }

        ListNode head = null, tail = null;

        while (!queue.isEmpty()){
            ListNode node = queue.poll();

            if(head==null){
                head = tail = node;
            }else{
                tail.next = node;
                tail = tail.next;
            }
            if(node!=null){
                node = node.next;
                queue.add(node);
            }
        }
        return head;
    }
}
