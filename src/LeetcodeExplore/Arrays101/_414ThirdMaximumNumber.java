package LeetcodeExplore.Arrays101;
//https://leetcode.com/problems/third-maximum-number/

import java.util.HashSet;
import java.util.PriorityQueue;

public class _414ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums){
            if(!set.contains(i)){
                queue.offer(i);
                set.add(i);
                if(queue.size()> 3){
                    queue.poll();
                }
            }
        }
        if(queue.size()< 3){
            while (queue.size()> 1){
                queue.poll();
            }
        }
        return queue.peek();
    }
}
