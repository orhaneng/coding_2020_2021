package LeetcodeExplore.LinkedList;
//https://leetcode.com/problems/design-linked-list/

public class _707DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1,2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);

    }
}

class MyLinkedList {

    private Node head;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) return -1;
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node prev = head;
        head = new Node(val);
        head.next = prev;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if(head==null){
            head = new Node(val);
        }else {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = new Node(val);
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if(index>size)  return;
        else if(index==size) addAtTail(val);
        else if(index==0) addAtHead(val);
        else{
            Node node = new Node(val);
            Node curr = head;
            for (int i = 0; i <index-1 ; i++) {
                curr = curr.next;
            }
            node.next = curr.next;
            curr.next = node;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if(index>=size) return;
        if (index == 0) head = head.next;
        else{
            Node curr = head;
            for (int i = 0; i <index-1 ; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        size--;

    }

}

