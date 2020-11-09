package LeetcodeExplore.HashTable;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashMap;
import java.util.HashSet;

public class _3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        StringBuilder builder = new StringBuilder();
        int max = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int index = builder.indexOf(String.valueOf(arr[i]));
            if (index != -1) {
                builder = new StringBuilder().append(builder.substring(index+1));
            }
            builder.append(arr[i]);
            max = Math.max(max, builder.length());
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
