package LeetcodeExplore.QueueStack;
//https://leetcode.com/problems/evaluate-reverse-polish-notation/

import java.util.Stack;

public class _150EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for(String x: tokens){
            //+, -, *, /.
            if(x.equals("+"))  {
                Integer item1 = stack.pop();
                Integer item = stack.pop();
                stack.push(item+item1);
            }
            else if(x.equals("/")) {
                Integer item1 = stack.pop();
                Integer item = stack.pop();
                stack.push(item/item1);
            }
            else if(x.equals("-")) {
                Integer item1 = stack.pop();
                Integer item = stack.pop();
                stack.push(item-item1);
            }
            else if(x.equals("*")) {
                Integer item1 = stack.pop();
                Integer item = stack.pop();
                stack.push(item*item1);
            }else
                stack.push(Integer.valueOf(x));

        }
        return stack.pop();
    }
}
