package LeetcodeExplore.LinkedList;
//https://leetcode.com/problems/remove-linked-list-elements/

public class _203RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode res = removeElements(head,1);

    }
    public static ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }

        ListNode node = head;
        ListNode prev = null;
        if(node.val==val){
            node = node.next;
        }

        while(node!=null && node.next !=null ){
            prev = node;

            if(node.val == val){
                node.next = node.next.next;
            }
            else {
                node=node.next;
            }
        }
        return head;
    }
}
