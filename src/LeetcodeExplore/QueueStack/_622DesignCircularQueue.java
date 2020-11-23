package LeetcodeExplore.QueueStack;
//https://leetcode.com/problems/design-circular-queue/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _622DesignCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(2);

    }
}

class MyCircularQueue {

    int[] arr;
    int front, rear = -1, len = 0;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        arr = new int[k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (!isFull()) {
            rear = (rear + 1) % arr.length;
            arr[rear] = value;
            len++;
            return true;
        } else return false;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % arr.length;
            len--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return isEmpty() ? -1 : front;
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        return isEmpty() ? -1 : rear;
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return len == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return arr.length == len;
    }
}