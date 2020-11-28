package LeetcodeExplore.LinkedList;

//https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/

public class _708InsertintoaSortedCircularLinkedList {

    public Node insert(Node start, int x) {
        if(start== null){
            Node node= new Node(x);
            node.next =node;
            return node;
        }
        Node cur =start;
        while (true){
            if(cur.val<cur.next.val){
                if(cur.val<=x && cur.next.val>=x){
                    cur.next = new Node(x,cur.next);
                    break;
                }
            }
            else if(cur.val>cur.next.val){
                if(cur.val<=x || x <=cur.next.val){
                    cur.next = new Node(x,cur.next);
                    break;
                }
            }else {
                if(cur.next == start){
                    cur.next = new Node(x,cur.next);
                    break;
                }
            }
            cur = cur.next;
        }
        return start;
    }
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
}
