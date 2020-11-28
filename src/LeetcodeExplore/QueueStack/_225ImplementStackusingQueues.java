package LeetcodeExplore.QueueStack;
//https://leetcode.com/problems/implement-stack-using-queues/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _225ImplementStackusingQueues {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(2);
        queue.offer(2);
        queue.peek();
        queue.remove();
        queue.poll();

        Stack<Integer> stack = new Stack<>();
        stack.add(2);
        stack.push(2);
        stack.pop();
        stack.peek();
    }
}


class MyStack {

    Queue<Integer> queue = new LinkedList<Integer>();
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for(int i=1;i<queue.size();i++){
            queue.add(queue.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}