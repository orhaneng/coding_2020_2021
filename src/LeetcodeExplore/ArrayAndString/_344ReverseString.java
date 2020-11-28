package LeetcodeExplore.ArrayAndString;
//https://leetcode.com/problems/reverse-string/
public class _344ReverseString {
    public void reverseString(char[] s) {
        if(s.length ==0) return;

        int begin = 0;
        int end = s.length-1;
        while(end>begin){
            char temp = s[begin];
            s[begin++] = s[end];
            s[end--] = temp;
        }
    }
}
