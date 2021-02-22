package LeetcodeAmazon;


//https://leetcode.com/problems/break-a-palindrome/

public class _1328BreakaPalindrome {
    /*
    TIME O(N)
    SPACE O(N)
     */
    class Solution {
        public String breakPalindrome(String palindrome) {

            char[] arr = palindrome.toCharArray();
            int n = palindrome.length();
            if (n==1)
                return "";

            for(int i=0;i<n/2;i++){
                if(arr[i]!='a'){
                    arr[i]='a';
                    return String.valueOf(arr);
                }
            }

            arr[n-1]='b';

            return String.valueOf(arr);
        }
    }
}
