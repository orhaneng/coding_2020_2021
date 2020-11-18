package LeetcodeExplore.RecursionI;

import java.util.Arrays;

public class _344ReverseString {
    public static void main(String[] args) {
        char[] arr = new char[]{'h','e','l','l','o'};
        reverseString(arr);

    }
    public static void reverseString(char[] s) {
        if(s.length==0) return;
        helper(s,0,s.length-1);
    }

    public static void helper(char[] arr, int begin,int end){
        if(begin>end) return;
        char temp = arr[begin];
        arr[begin] = arr[end];
        arr[end]=temp;
        helper(arr, ++begin,--end);

    }
}
