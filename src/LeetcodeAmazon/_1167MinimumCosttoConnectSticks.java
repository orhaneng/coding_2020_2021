package LeetcodeAmazon;

//https://leetcode.com/problems/minimum-cost-to-connect-sticks/

import java.util.PriorityQueue;

public class _1167MinimumCosttoConnectSticks {
    class Solution {
        public int connectSticks(int[] sticks) {
            PriorityQueue<Integer> minHeap =new PriorityQueue<Integer>();

            for(int item:sticks){
                minHeap.add(item);
            }

            int cost = 0;
            while(minHeap.size()>1){
                int first = minHeap.poll();
                int second = minHeap.poll();
                cost +=first+second;
                minHeap.add(first+second);
            }
            return cost;
        }
    }
}
