package LeetcodeExplore.RecursionI.ArrayAndString;
//https://leetcode.com/problems/reverse-words-in-a-string/

public class _151ReverseWordsinaString {
    public static String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder builder = new StringBuilder();

        for(int i=arr.length-1;i>=0;i--){
            if(arr[i].equals("")) continue;
            builder.append(arr[i]);
            if(i!=0){
                builder.append(" ");
            }
        }

        return builder.toString().trim();
    }
}
