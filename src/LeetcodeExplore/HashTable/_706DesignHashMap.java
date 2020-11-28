package LeetcodeExplore.HashTable;

//https://leetcode.com/problems/design-hashmap/

import java.util.Arrays;

public class _706DesignHashMap {

    ListNode[] listNodes = new ListNode[10000];

    public void put(int key, int val) {
        int i = idx(key);
        if (listNodes[i] == null) {
            listNodes[i] = new ListNode(-1, -1);
        }
        ListNode prev = find(listNodes[i], key);

        if (prev.next == null) {
            prev.next = new ListNode(key, val);
        } else prev.next.val = val;
    }

    public void remove(int key) {
        int i = idx(key);
        if (listNodes[i] == null) return;

        ListNode prev = find(listNodes[i], key);
        prev.next = prev.next.next;
    }

    public int get(int key) {
        int i = idx(key);
        if (listNodes[i] == null) {
            return -1;
        }
        ListNode node = find(listNodes[i], key);
        return node.next == null ? -1 : node.next.val;
    }

    ListNode find(ListNode bucket, int key) {
        ListNode node = bucket, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    int idx(int key) {
        return Integer.hashCode(key) % listNodes.length;
    }

    class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

class MyHashMap {

    int[] map;

    public MyHashMap() {
        map = new int[1000001];
        Arrays.fill(map, -1);
    }

    public int get(int key) {
        return map[key];
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public void remove(int key) {
        map[key] = -1;
    }
}
