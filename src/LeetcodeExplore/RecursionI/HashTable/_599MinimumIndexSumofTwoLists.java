package LeetcodeExplore.RecursionI.HashTable;

import java.util.*;

//https://leetcode.com/problems/minimum-index-sum-of-two-lists/
public class _599MinimumIndexSumofTwoLists {

    public static void main(String[] args) {
        findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                new String[]{"KFC","Shogun","Burger King"});
    }
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<String, Integer>();
        List<String> res = new ArrayList<String>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<list2.length;i++){
            Integer j = map.get(list2[i]);
            if(j!=null && j+i<=min){
                if(j+i<min){res.clear();min = i+j;}
                res.add(list2[i]);
            }
        }

        return res.toArray(new String[res.size()]);
    }
}
