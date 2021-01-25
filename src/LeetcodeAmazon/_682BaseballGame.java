package LeetcodeAmazon;

//https://leetcode.com/problems/baseball-game/

import java.util.Stack;

/*
Time Complexity: O(N)O(N), where NN is the length of ops. We parse through every element in the given array once, and do O(1)O(1) work for each element.

Space Complexity: O(N)O(N), the space used to store our stack.

 */
public class _682BaseballGame {
    public static void main(String[] args) {
        String[] input = new String[]{"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(input));
    }

    public static int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<ops.length;i++){
            if (ops[i].equals("C")){
                stack.pop();
            }else if(ops[i].equals("D")){
                int num1=stack.pop();
                stack.push(num1);
                stack.push(num1*2);
            }else if(ops[i].equals("+")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.push(num2);
                stack.push(num1);
                stack.push(num1+num2);
            }else{
                stack.push(Integer.valueOf(ops[i]));
            }
        }

        int sum=0;
        while(!stack.isEmpty())
            sum += stack.pop();

        return sum;
    }
}
