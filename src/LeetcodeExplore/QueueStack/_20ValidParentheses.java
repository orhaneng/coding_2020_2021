package LeetcodeExplore.QueueStack;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/
public class _20ValidParentheses {
    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }
    public static  boolean isValid(String s) {
        if (s== null) return false;
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char item:arr ) {
            if(item ==  '(' || item == '[' || item == '{'){
                stack.push(item);
            }
            else if(item == ')' && !stack.isEmpty() && stack.peek()== '('){
                stack.pop();
            }
           else if(item == ']' && !stack.isEmpty() && stack.peek()== '['){
                stack.pop();
            }
           else if(item == '}' && !stack.isEmpty() && stack.peek()== '{'){
                stack.pop();
            }
            else return false;
        }
        return stack.isEmpty();
    }
}
