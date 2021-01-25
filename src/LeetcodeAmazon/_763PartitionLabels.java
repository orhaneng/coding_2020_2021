package LeetcodeAmazon;

//https://leetcode.com/problems/partition-labels/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class _763PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        partitionLabels(s).forEach(System.out::println);
    }

    public static List<Integer> partitionLabels(String S) {
        HashMap<Character, Integer[]> map = new HashMap<>();
        List<Integer> result = new ArrayList<Integer>();
        char[] arr = S.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                Integer[] ind = map.get(arr[i]);
                ind[1] = i;
                map.put(arr[i], ind);
            } else {
                Integer[] ind = new Integer[2];
                ind[0] = i;
                ind[1] = i;
                map.put(arr[i], ind);
            }
        }

        PriorityQueue<Integer[]> minheap = new PriorityQueue<Integer[]>((a, b) -> a[0] - b[0]);

        for (Integer[] value : map.values()) {
            minheap.add(value);
        }
        int start=0;
        int end=0;
        while (!minheap.isEmpty()){
            Integer[] item = minheap.poll();
             if(item[0]<=end){
                end = Math.max(end, item[1]);
                start = Math.min(start,item[0]);
            }else{
                result.add(end-start+1);
                start= item[0];
                end=item[1];
            }
        }
        result.add(end-start+1);
        return result;
    }
}
