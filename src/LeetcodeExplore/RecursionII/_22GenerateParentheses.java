package LeetcodeExplore.RecursionII;
//https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;

public class _22GenerateParentheses {
    public static void main(String[] args) {
        generateParenthesis(3).stream().forEach(System.out::println);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtrack(res, "", n, 0, 0);
        return res;

    }

    public static void backtrack(List<String> res, String text, int n, int first, int second) {
        System.out.println(text + ",open:"+first+",close:"+second);
        if (text.length() == n * 2) {
            res.add(text);
            return;
        }

        if (first < n)
            backtrack(res, text + "(", n, first + 1, second);
        if (second < first)
            backtrack(res, text + ")", n, first, second + 1);


    }
}
