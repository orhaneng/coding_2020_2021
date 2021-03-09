package LeetcodeAmazon;

//https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.PriorityQueue;

public class _23MergekSortedLists {


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

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>
                    ((a, b) -> a.val - b.val);

            if (lists.length == 0)
                return null;
            for (ListNode node : lists) {
                if (node != null)
                    minHeap.add(node);
            }

            ListNode root = new ListNode(-1);
            ListNode node = root;

            while (!minHeap.isEmpty()) {
                ListNode item = minHeap.poll();
                node.next = item;
                node = node.next;
                if (node.next != null)
                    minHeap.add(item.next);
            }

            return root.next;
        }
    }
}
