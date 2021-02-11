package LeetcodeAmazon;

//https://leetcode.com/problems/top-k-frequent-words/

import java.util.*;

public class _692TopKFrequentWords {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{3, 1, 4}));
        list.sort((a, b) -> {
            if (a == b) return 0;
            else if (a < b) return -1;
            else return 1;
        });

        // list.forEach(System.out::print);
        //list.sort((a, b) -> a - b);


        String[] arr = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        List<String> res = Solution.topKFrequent(arr, 4);
        res.forEach(System.out::print);



    }

    static class Solution {

        //TIME O(NLOGK) SPACE O(N)

//        public static class item {
//            String st;
//            Integer count;
//
//            public item(String st, Integer count) {
//                this.st = st;
//                this.count = count;
//            }
//        }

        public static List<String> topKFrequent(String[] words, int k) {
            LinkedList<String> res = new LinkedList<String>();

            if (k == 0 || words.length == 0)
                return res;

            HashMap<String, Integer> map = new HashMap();

            for (String item : words) {
                map.put(item, map.getOrDefault(item, 0) + 1);
            }

       /*
        PriorityQueue<item> queue = new PriorityQueue<>((a, b) -> {
            if (a.count < b.count)
                return -1;
            else if (a.count > b.count)
                return 1;
            else {
                return b.st.compareTo(a.st);
            }
        });
        */

            PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> (a.getValue()==b.getValue()?
                    b.getKey().compareTo(a.getKey()):a.getValue()-b.getValue()));

            for (Map.Entry<String, Integer> it : map.entrySet()) {
                queue.add(it);
                if (queue.size() > k) {
                    queue.poll();
                }
            }

            while (queue.size() > 0) {
                res.add(0,queue.poll().getKey());
            }

            return res;
        }
    }
}


