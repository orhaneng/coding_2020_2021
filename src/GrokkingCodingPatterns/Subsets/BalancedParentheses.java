package GrokkingCodingPatterns.Subsets;

//https://leetcode.com/problems/generate-parentheses/


import java.util.ArrayList;
import java.util.List;

public class BalancedParentheses {

    public static void main(String[] args) {
        generateParenthesis(3).forEach(System.out::println);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0,0,n);
        return res;
    }

    public static void backtrack(List<String> list, String text, int open, int close, int n ){

        if(text.length() == n*2){
            list.add(text);
        }

        if(open<n){
            backtrack(list, text+"(", open+1,close,n);
        }
        if(open>close){
            backtrack(list,text+")", open,close+1,n);
        }
    }
}
