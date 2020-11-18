package LeetcodeExplore.RecursionI.HashTable;

//https://leetcode.com/problems/jewels-and-stones/

import java.util.HashMap;

public class _771JewelsandStones {

    public static int numJewelsInStones(String J, String S) {
        char[] arr = S.toCharArray();
        char[] jarr = J.toCharArray();
        int count=0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();

        for(Character c:arr){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(Character c:jarr){
            if(map.containsKey(c)){
                count += map.get(c);
            }
        }
        return count;
    }
}
