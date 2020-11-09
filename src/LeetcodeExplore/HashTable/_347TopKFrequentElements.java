package LeetcodeExplore.HashTable;
//https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;

public class _347TopKFrequentElements {


    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        topKFrequent2(nums, 2);

    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(Collections.reverseOrder());
        int[] res = new int[k];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!treeMap.containsKey(entry.getValue())) {
                treeMap.put(entry.getValue(), new LinkedList<>());
            }
            treeMap.get(entry.getValue()).add(entry.getKey());
        }

        int index = 0;
        while (k > 0 && treeMap.size() > 0) {
            Map.Entry<Integer, List<Integer>> entry = treeMap.pollFirstEntry();
            List<Integer> list = entry.getValue();
            for (Integer item : list) {
                res[index++]=item;
                k--;
            }

        }
        return res;

    }

    public static List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        // corner case: if there is only one number in nums, we need the bucket has index 1.
        List<Integer>[] bucket = new List[nums.length+1];
        for(int n:map.keySet()){
            int freq = map.get(n);
            if(bucket[freq]==null)
                bucket[freq] = new LinkedList<>();
            bucket[freq].add(n);
        }

        List<Integer> res = new LinkedList<>();
        for(int i=bucket.length-1; i>0 && k>0; --i){
            if(bucket[i]!=null){
                List<Integer> list = bucket[i];
                res.addAll(list);
                k-= list.size();
            }
        }

        return res;
    }
}