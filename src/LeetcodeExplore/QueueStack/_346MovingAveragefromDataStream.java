package LeetcodeExplore.QueueStack;

//https://leetcode.com/problems/moving-average-from-data-stream/

import java.util.LinkedList;
import java.util.Queue;

public class _346MovingAveragefromDataStream {
    class MovingAverage {

        Queue<Integer> queue =null;
        double sum=0;
        int size=0;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            queue = new LinkedList<>();
            this.size=size;
        }

        public double next(int val) {
            if(queue.size()==size){
                Integer m = queue.remove();
                sum =sum-m;
            }
            queue.add(val);
            sum = sum+val;
            return sum/queue.size();
        }
    }
}
