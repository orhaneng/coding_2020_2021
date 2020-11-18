package LeetcodeExplore.RecursionI.HashTable;

//https://leetcode.com/problems/group-anagrams/

import java.util.*;

public class _49GroupAnagrams {
    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams2(str);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String item:strs){
            char[] arr = item.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if(map.containsKey(key)){
                map.get(key).add(item);
            }else{
                List<String> list = new ArrayList<String>();
                list.add(item);
                map.put(key,new ArrayList<String>());
                map.get(key).add(item);

            }
        }

        return new ArrayList(map.values());
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
