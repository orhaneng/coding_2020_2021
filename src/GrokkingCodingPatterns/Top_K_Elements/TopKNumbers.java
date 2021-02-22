package GrokkingCodingPatterns.Top_K_Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TopKNumbers {


    public static void main(String[] args) {
        //findKLargestNumbers(new int[]{5, 12, 11, -1, 12},3).forEach(System.out::println);
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
    public static List<Integer> findKLargestNumbers(int[] nums, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int num:nums){
            queue.add(num);
            if(queue.size()>k)
                queue.poll();
        }

        return new ArrayList<>(queue);
    }


    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        for(int num:nums){
            queue.add(num);
            if(queue.size()>k)
                queue.poll();
        }
        return queue.poll();
    }
}
