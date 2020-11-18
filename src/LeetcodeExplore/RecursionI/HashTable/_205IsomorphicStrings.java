package LeetcodeExplore.RecursionI.HashTable;

import java.util.HashMap;

//https://leetcode.com/problems/isomorphic-strings/
public class _205IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg","add"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b))
                    continue;
                else
                    return false;
            }else{
                if(!map.containsValue(b))
                    map.put(a,b);
                else return false;

            }
        }
        return true;

    }
}
