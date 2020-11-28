package LeetcodeExplore.ArrayAndString;
//https://leetcode.com/problems/longest-common-prefix/

public class _14LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arr = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(arr));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String pre = strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(pre)!=0){
                pre = pre.substring(0,pre.length()-1);
            }
        }
        return pre;
    }
}
