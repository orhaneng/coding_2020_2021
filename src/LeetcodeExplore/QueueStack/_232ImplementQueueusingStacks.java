package LeetcodeExplore.QueueStack;
//https://leetcode.com/problems/implement-queue-using-stacks/

import java.util.Stack;

public class _232ImplementQueueusingStacks {
}

class MyQueue {
    Stack<Integer> first = new Stack<Integer>();
    Stack<Integer> second = new Stack<Integer>();
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        first.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return second.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(second.isEmpty()){
            while(!first.isEmpty()){
                second.push(first.pop());
            }
        }
        return second.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return second.isEmpty() && first.isEmpty();
    }
}
